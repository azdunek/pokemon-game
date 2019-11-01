package pokemons;

import attacks.Attack;

import java.util.ArrayList;

public abstract class Pokemon {
    private String description;
    private int HP;
    private PokemonType type;
    private int level;
    private int experience;
    private String sound;
    protected ArrayList<Attack> attacks;
    private PokemonType vulnerability;
    private String picture;

    public Pokemon(String description, int HP, PokemonType type, int level, int experience, String sound, PokemonType vulnerability, String picture) {
        this.description = description;
        this.HP = HP;
        this.type = type;
        this.level = level;
        this.experience = experience;
        this.sound = sound;
        this.attacks = attacks;
        this.vulnerability = vulnerability;
        this.picture = picture;
    }



}
