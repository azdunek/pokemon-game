package game;

import pokemons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Trainer {
    private String name;
    private ArrayList<Pokemon> pokemons;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> shouts;

    Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<Pokemon>();
        pokemons.add(new Pikachu());
        pokemons.add(new Squirtle());
        pokemons.add(new Charmander());
        pokemons.add(new Bulbasaur());
        this.shouts = new ArrayList<>();
        shouts.add("I choose you!");
        shouts.add("You will be my Pokemon! ");
        shouts.add("Fight with me!");
        shouts.add("Stand up and fight!");
    }


    String getName() {
        return name;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    Pokemon chooseRandomPokemon() {
        int number = randomWithRange(0, pokemons.size() - 1);
        return pokemons.get(number);
    }

    String getRandomShout() {
        int number = randomWithRange(0, shouts.size() - 1);
        return shouts.get(number);
    }

    Pokemon selectPokemon() {
        System.out.println("Choose your pokemon!");
        displayPokemonList();

        int number = scanner.nextInt();
        while (number < 0 || number >= pokemons.size()) {
            System.out.println("Error! Choose again!");
            number = scanner.nextInt();
        }
        return pokemons.get(number);
    }

    private void displayPokemonList() {
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println(i + " " + pokemons.get(i).getClass().getSimpleName());
        }
    }


    private int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}

