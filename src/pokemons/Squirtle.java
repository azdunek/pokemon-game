package pokemons;

import attacks.Attack;
import attacks.Fontain;
import attacks.Tsunami;
import attacks.Wave;
import game.Images;

import java.util.ArrayList;

public class Squirtle extends Pokemon {
    public Squirtle() {
        super("Squirtle's shell is not merely used for protection. " +
                "The shell's rounded shape and the grooves on its surface help minimize resistance in water, " +
                "enabling this Pokémon to swim at high speeds.", 100, PokemonType.WATER, 1, 0, "Squirtle!",
                PokemonType.ELECTRIC, Images.getSquirtle());
        attacks.add(new Wave());
        attacks.add(new Fontain());
        attacks.add(new Tsunami());
    }
}
