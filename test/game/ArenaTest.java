package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArenaTest {

    @Test
    void shouldReturnRandomInGivenRange() {
        Arena arena = new Arena();
        int result = arena.randomWithRange(1, 10);
        Assertions.assertTrue(result>=1 && result<=10);
    }
}
