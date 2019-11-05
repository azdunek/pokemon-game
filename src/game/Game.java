package game;

import attacks.Attack;
import pokemons.Pokemon;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    private Trainer player;
    Scanner scanner = new Scanner(System.in);
    Arena arena = new Arena();
    private Trainer opponent;
    private Pokemon fightingPokemon;
    private Pokemon myPokemon;
    private final int TIMING = 500;

    public void play() {
        //TODO: z metody atakującej wyodrębnić metodę obliczającą siłę obrażeń w zależności od typu twojego pokemona i typu pokemona przeciwnika

        System.out.println(Images.getPokemonLogo());
        loading();
        getPlayerName();
        clearConsole();
        welcomePlayer();
        loading();
        clearConsole();
        System.out.println("Selecting opponent...");
        opponent = arena.getRandomOpponent();
        loading();
        System.out.println("Your opponent: " + opponent.getName());


        System.out.println("Selecting pokemon...");
        fightingPokemon = opponent.chooseRandomPokemon();
        loading();
        clearConsole();

        choosePokemonDialog(opponent, fightingPokemon);
        // TODO: User wants to choose fighting pokemon from default set of Pokemons by himself.

        System.out.println("Selecting pokemon...");
        myPokemon = player.chooseRandomPokemon();
        loading();
        clearConsole();

        choosePokemonDialog(player, myPokemon);
        displayLetsFight();
        fight();
        announceWinner();

    }


    private void announceWinner() {
        if (myPokemon.getHP() > fightingPokemon.getHP()) {
            System.out.println("Congratulations! You won this fight!");
        } else {
            System.out.println("You lost! You must try harder!");
        }

    }

    private void getPlayerName() {
        System.out.println("Enter your name: ");
        player = new Trainer(scanner.nextLine());
    }

    private void welcomePlayer() {
        System.out.println("Welcome " + player.getName() + " in our arena! Let's Fight!");
    }

    private void displayLetsFight() {
        System.out.println(fightingPokemon.getClass().getSimpleName() + " vs. " + myPokemon.getClass().getSimpleName() + "! Let's fight!");
        loading();
        clearConsole();
    }

    private void fight() {
        while (myPokemon.getHP() > 0 && fightingPokemon.getHP() > 0) {
            attackOpponent(player, myPokemon, fightingPokemon);
            if (myPokemon.getHP() <= 0 || fightingPokemon.getHP() <= 0) {
                break;
            } else {
                attackOpponent(opponent, fightingPokemon, myPokemon);
            }
        }
    }


    private void choosePokemonDialog(Trainer trainer, Pokemon pokemon) {
        // TODO: Make more shouts and get random one.
        String message = " I choose you!";
        System.out.println(trainer.getName().toUpperCase() + ": " + pokemon.getClass().getSimpleName() + message);
        System.out.println(pokemon.getPicture());
        loading();
        clearConsole();
    }


    private Attack chooseAttack(Pokemon pokemon) {
        pokemon.displayAttackslist();
        System.out.println("Enter attack number: ");
        int number = scanner.nextInt();
        while (number < 0 || number >= pokemon.getAttacks().size()) {
            System.out.println("You don't have attack with this number! Choose another one!");
            number = scanner.nextInt();
        }
        return pokemon.getAttacks().get(number);
    }

    private void attackOpponent(Trainer trainer, Pokemon attackingPokemon, Pokemon defendingPokemon) {
        Attack attack;
        if (trainer == player) {
            attack = chooseAttack(attackingPokemon);
        } else {
            attack = fightingPokemon.getRandomAttack();
        }
        System.out.println(trainer.getName().toUpperCase() + ": " + attackingPokemon.getClass().getSimpleName() + ", use " + attack.getName() + "!");
        defendingPokemon.setHP(defendingPokemon.getHP() - attack.getStrength());
        System.out.println(defendingPokemon.getClass().getSimpleName() + " got " + attack.getStrength() + " points of damage!");
        getHealthStatus(defendingPokemon);
        loading();
        clearConsole();
    }




    private void getHealthStatus(Pokemon pokemon) {
        System.out.println(pokemon.getClass().getSimpleName() + " health = " + pokemon.getHP());
    }


    private void loading() {
        try {
            Thread.sleep(TIMING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

}
