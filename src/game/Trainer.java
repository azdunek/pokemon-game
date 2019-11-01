package game;

import pokemons.*;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private ArrayList<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<Pokemon>();
        pokemons.add(pikachu);
        pokemons.add(squirtle);
        pokemons.add(charmander);
        pokemons.add(bulbasaur);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Pokemon chooseRandomPokemon(){
        int number =randomWithRange(0,pokemons.size()-1);
        return pokemons.get(number);
    }


    int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    Pokemon pikachu = new Pikachu();
    Pokemon squirtle = new Squirtle();
    Pokemon charmander = new Charmander();
    Pokemon bulbasaur =new Bulbasaur();


}
