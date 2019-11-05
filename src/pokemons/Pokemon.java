package pokemons;

import attacks.Attack;
import utils.RandomNumber;

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
        this.attacks = new ArrayList<>();
        this.vulnerability = vulnerability;
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }
    public void displayAttackslist(){
        for (int i=0; i<attacks.size(); i++) {
            System.out.println("Attack number "+i+"  "+attacks.get(i).getName());
        }
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public Attack getRandomAttack() {
        int number = RandomNumber.fromRange(0, attacks.size() - 1);
        return attacks.get(number);
    }



    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }
}
