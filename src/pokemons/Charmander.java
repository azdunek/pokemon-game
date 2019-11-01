package pokemons;

import attacks.Attack;
import attacks.Blaze;
import attacks.FireSparkle;
import attacks.FireTornado;
import game.Images;

import java.util.ArrayList;

public class Charmander extends Pokemon{
    public Charmander() {
        super("The flame that burns at the tip of its tail is an indication of its emotions. " +
                "The flame wavers when Charmander is enjoying itself. " +
                "If the Pokémon becomes enraged, the flame burns fiercely.", 20, PokemonType.FIRE, 1, 0,
                "Chaaaar", PokemonType.WATER, Images.getCharmander());
        attacks.add(new Blaze());
        attacks.add(new FireSparkle());
        attacks.add(new FireTornado());
    }
}
