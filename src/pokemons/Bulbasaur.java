package pokemons;

import attacks.Attack;
import attacks.Creeper;
import attacks.Earthquake;
import attacks.MudRain;
import game.Images;

import java.util.ArrayList;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        super("Bulbasaur can be seen napping in bright sunlight. There is a seed on its back." +
                " By soaking up the sun's rays, the seed grows progressively larger.", 20, PokemonType.GRASS, 1, 0,
                "Bulbasaaauuur", PokemonType.FIRE, Images.getBulbasaur());
        attacks.add(new Creeper());
        attacks.add(new MudRain());
        attacks.add(new Earthquake());
    }
}
