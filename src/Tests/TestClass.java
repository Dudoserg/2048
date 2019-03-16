package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestClass {
    @Test
    void gameClassCreationTest(){
        Game game = new Game();
        Assertions.assertNotNull(game);

    }
}
