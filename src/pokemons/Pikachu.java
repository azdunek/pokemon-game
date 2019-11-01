package pokemons;

import attacks.Attack;
import attacks.ElectricBeam;
import attacks.Shock;
import attacks.Thunderstruck;
import game.Images;

public class Pikachu extends Pokemon {

    public Pikachu() {
        super("Whenever Pikachu comes across something new, it blasts it with a jolt of electricity." +
                " If you come across a blackened berry, it's evidence that this Pokémon mistook the intensity of its charge.", 20,
               PokemonType.ELECTRIC , 1, 0, "Pika Pika",  PokemonType.GROUND, Images.getPikachu());
        attacks.add(new ElectricBeam());
        attacks.add(new Shock());
        attacks.add(new Thunderstruck());

    }

    //TODO: ataki!
    int attack() {
        Attack attack = getRandomAttack(); // userChooses Attack

        attack.getStrength();
        return damage;
    }

}
