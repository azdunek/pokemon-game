package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pokemons.Charmander;
import pokemons.Pikachu;
import pokemons.Pokemon;
import pokemons.Squirtle;

class GameTest {

    @Test
    void shouldCalculateDamageWhenNeutral() {
        Game game = new Game();
        Pokemon attacker = new Pikachu();
        Pokemon defender = new Charmander();
        int strength = 50;

        int expectedLowerLimit = (strength - 10);
        int expectedHigherLimit = (strength + 10);

        int result = game.calculateDamage(50, attacker, defender);

        Assertions.assertTrue(result >= expectedLowerLimit && result <= expectedHigherLimit);
    }

    @Test
    void shouldCalculateDamageWhenTheSameType() {
        Game game = new Game();
        Pokemon attacker = new Pikachu();
        Pokemon defender = new Pikachu();
        int strength = 50;

        int expectedLowerLimit = (int) ((strength - 10) * 0.4);
        int expectedHigherLimit = (int) ((strength + 10) * 0.4);

        int result = game.calculateDamage(50, attacker, defender);

        Assertions.assertTrue(result >= expectedLowerLimit && result <= expectedHigherLimit);
    }

    @Test
    void shouldCalculateDamageWhenVurnelable() {
        Game game = new Game();
        Pokemon attacker = new Squirtle();
        Pokemon defender = new Charmander();
        int strength = 50;

        int expectedLowerLimit = (int) ((strength - 10) * 1.4);
        int expectedHigherLimit = (int) ((strength + 10) * 1.4);

        int result = game.calculateDamage(50, attacker, defender);

        Assertions.assertTrue(result >= expectedLowerLimit && result <= expectedHigherLimit);
    }


}
