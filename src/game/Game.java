package game;

import pokemons.Pokemon;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    private Trainer player;
    Scanner scanner = new Scanner(System.in);
    Arena arena = new Arena();
    private Trainer opponent;
    private Pokemon fightingPokemon;
    private Pokemon myPokemon;

    public void play() {


        System.out.println("Napis pokemoooon!");
        getPlayerName();
        welcomePlayer();
        opponent=arena.getRandomOpponent();
        fightingPokemon=opponent.chooseRandomPokemon();
        myPokemon=player.chooseRandomPokemon();



    }


    private void getPlayerName() {
        System.out.println("Enter your name: ");
        player.setName(scanner.nextLine());

    }

    private void welcomePlayer() {
        System.out.println("Welcome " + player.getName() + " in our arena! Let's Fight!");
    }


}
