package game;

import attacks.Attack;
import pokemons.Pokemon;
import utils.RandomNumber;

import java.util.Scanner;

class Game {
    private Trainer player;
    private Scanner scanner = new Scanner(System.in);
    private Arena arena = new Arena();
    private Trainer opponent;
    private Pokemon fightingPokemon;
    private Pokemon myPokemon;
    private final int TIMING = 1500;

    void play() {
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

        System.out.println("Selecting pokemon...");
        myPokemon = player.selectPokemon();
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
        System.out.println(trainer.getName().toUpperCase() + ": " + pokemon.getClass().getSimpleName() + trainer.getRandomShout());
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
        int calculatedDamage = calculateDamage(attack.getStrength(), attackingPokemon, defendingPokemon);
        System.out.println(trainer.getName().toUpperCase() + ": " + attackingPokemon.getClass().getSimpleName() + ", use " + attack.getName() + "!");
        defendingPokemon.setHP(defendingPokemon.getHP() - calculatedDamage);
        System.out.println(defendingPokemon.getClass().getSimpleName() + " got " + calculatedDamage + " points of damage!");
        getHealthStatus(defendingPokemon);
        loading();
        clearConsole();
    }

    int calculateDamage(int strength, Pokemon attackingPokemon, Pokemon defendingPokemon) {
        int damage = strength + RandomNumber.fromRange(-10, 10);
        if (attackingPokemon.getType() == defendingPokemon.getType()) {
            return (int) (damage * 0.4);
        }
        if (attackingPokemon.getType() == defendingPokemon.getVulnerability()) {
            return (int) (damage * 1.4);
        }
        return damage;
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
}
