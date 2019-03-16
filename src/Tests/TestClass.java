package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sample.Game;

import java.lang.reflect.Array;
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

    @Test
    void generateNumberTestbig(){
        Game game = new Game();
        int iterations = 1000000;
        int count_2 = 0;
        int count_4 = 0;
        for(int i = 0 ; i < iterations; i++){
            int num = game.generateNumber();
            if( num == 2 )
                count_2++;
            if( num == 4 )
                count_4++;
        }
        double percent_2 = ((double) count_2) / iterations;
        double percent_4 = ((double)count_4) / iterations;
        double epsilon = 0.1;
        Assertions.assertTrue( (percent_2 > 0.9 - epsilon) &&  (percent_2 < 0.9 + epsilon)
                &&  (percent_4 > 0.1 - epsilon) &&  (percent_4 < 0.4 + epsilon) );

    }

    @Test
    void initArrayTest(){
        Game game = new Game();
        game.init();
        Assertions.assertNotNull(game.getArr());
    }

    @Test
    void setSizeTest(){
        Game game = new Game(4);

        Assertions.assertEquals(game.getSize(), 4);
    }

    @Test
    void setElemInArrayTest(){
        Game game = new Game(4);
        game.init();
        game.setElem(0,0,54);
        Assertions.assertEquals(game.getElem(0,0), 54);
    }

    @Test
    void findFreePlaceInArray(){
        Game game = new Game(4);
        game.init();
        game.setElem(0,0, 54);

        Assertions.assertArrayEquals(game.findFreePlace(), new int[] {3,3});
    }


}
