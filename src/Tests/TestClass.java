package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Game;

import java.util.ArrayList;

public class TestClass {
    @Test
    void gameClassCreationTest(){
        Game game = new Game();
        Assertions.assertNotNull(game);

    }

    @Test
    void addTwoNumbersTest1(){
        Game game = new Game();
        Assertions.assertEquals(game.add(4,4), 8);
    }
    @Test
    void addTwoNumbersTest8x8(){
        Game game = new Game();
        Assertions.assertEquals(game.add(8,8), 16);
    }
    @Test
    void addTwoNumbersTest16x16(){
        Game game = new Game();
        Assertions.assertEquals(game.add(16,16), 32);
    }

    @Test
    void generateNumberTest(){
        Game game = new Game();
        int num = game.generateNumber();
        Assertions.assertTrue( num == 2 || num == 4);
    }
}
