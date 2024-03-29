package game;

import pokemons.Bulbasaur;
import pokemons.Pikachu;
import pokemons.Squirtle;

import java.util.ArrayList;

public class Arena {
    private ArrayList<Trainer> trainers;

    public Arena() {
        this.trainers = new ArrayList<>();
        Trainer trainer0 = new Trainer("Tom");
        Trainer trainer1 = new Trainer("Anny");
        Trainer trainer2 = new Trainer("Ash");
        Trainer trainer3 = new Trainer("Brock");
        Trainer trainer4 = new Trainer("Misty");
        trainers.add(trainer0);
        trainers.add(trainer1);
        trainers.add(trainer2);
        trainers.add(trainer3);
        trainers.add(trainer4);
    }

    public Trainer getRandomOpponent() {
        int number = randomWithRange(0, trainers.size() - 1);
        return trainers.get(number);
    }

    public int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }
}
