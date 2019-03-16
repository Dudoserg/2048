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

//    @Test
//    void findFreePlaceInArray(){
//        Game game = new Game(4);
//        game.init();
//        game.setElem(0,0, 54);
//        Assertions.assertArrayEquals(game.findFreePlace(), new int[] {3,3});
//    }

    @Test
    void findFreePlaceInArray2(){
        Game game = new Game(4);
        game.init();
        game.setElem(0,0, 54);
        boolean flagTrue = false;
        for(int i = 0 ; i < 10000; i++){
            int result[] = game.findFreePlace();
            if(result[0] == 3 && result[1] == 3)
                flagTrue = true;
        }
        Assertions.assertTrue(flagTrue);
    }

    @Test
    void randTest(){
        Game game = new Game(4);
        game.init();
        int result[] = new int[10];
        int countIteration = 1000000;
        for(int i = 0 ; i < countIteration; i++){
            result[game.rand(0,10)]++;
        }
        for(int i = 0 ; i < 10; i++){
            Assertions.assertTrue((result[i] > (countIteration/10) - ((double)countIteration / 100))
                    && (result[i] < (countIteration/10) + ((double)countIteration / 100)));
        }
    }

    @Test
    void LeftTest1(){
        Game game = new Game();
        game.init();
        game.setElem(0,0,16);game.setElem(0,1,4);game.setElem(0,2,4);game.setElem(0,3,0);
        game.setElem(1,0,2);game.setElem(1,1,0);game.setElem(1,2,0);game.setElem(1,3,0);
        game.setElem(2,0,2);game.setElem(2,1,0);game.setElem(2,2,2);game.setElem(2,3,0);
        game.setElem(3,0,0);game.setElem(3,1,0);game.setElem(3,2,0);game.setElem(3,3,0);

        game.left();

        int result[][] = {
                {16,8,0,0},
                {2,0,0,0},
                {4,0,0,0},
                {0,0,0,0},
        };

        Assertions.assertArrayEquals(result,game.getArr());
    }


    void rightTest1(){
        Game game = new Game();
        game.init();
        game.setElem(0,0,16);game.setElem(0,1,4);game.setElem(0,2,4);game.setElem(0,3,0);
        game.setElem(1,0,2);game.setElem(1,1,0);game.setElem(1,2,0);game.setElem(1,3,0);
        game.setElem(2,0,2);game.setElem(2,1,0);game.setElem(2,2,2);game.setElem(2,3,0);
        game.setElem(3,0,0);game.setElem(3,1,0);game.setElem(3,2,0);game.setElem(3,3,0);

        game.right();

        int result[][] = {
                {0,0,16,8},
                {0,0,0,2},
                {0,0,0,4},
                {0,0,0,0},
        };

        Assertions.assertArrayEquals(result,game.getArr());
    }

    @Test
    void motionElemTest(){
        Game game = new Game();
        game.init();
        game.setElem(0,0,16);game.setElem(0,1,4);game.setElem(0,2,4);game.setElem(0,3,0);
        game.setElem(1,0,2);game.setElem(1,1,0);game.setElem(1,2,0);game.setElem(1,3,0);
        game.setElem(2,0,2);game.setElem(2,1,0);game.setElem(2,2,2);game.setElem(2,3,0);
        game.setElem(3,0,0);game.setElem(3,1,0);game.setElem(3,2,0);game.setElem(3,3,0);

        game.motionElem(0, -1, 0, 0);
        int result[][] = {
                {16,4,4,0},
                {2,0,0,0},
                {2,0,2,0},
                {0,0,0,0},
        };
        Assertions.assertArrayEquals(result,game.getArr());

    }
    @Test
    void motionElemTest2(){
        Game game = new Game();
        game.init();
        game.setElem(0,0,16);game.setElem(0,1,4);game.setElem(0,2,4);game.setElem(0,3,0);
        game.setElem(1,0,2);game.setElem(1,1,0);game.setElem(1,2,0);game.setElem(1,3,0);
        game.setElem(2,0,2);game.setElem(2,1,0);game.setElem(2,2,2);game.setElem(2,3,0);
        game.setElem(3,0,0);game.setElem(3,1,0);game.setElem(3,2,0);game.setElem(3,3,0);

        game.motionElem(0, -1, 0, 2);
        int result[][] = {
                {16,8,0,0},
                {2,0,0,0},
                {2,0,2,0},
                {0,0,0,0},
        };
        Assertions.assertArrayEquals(result,game.getArr());

    }
    @Test
    void motionElemTest3(){
        Game game = new Game();
        game.init();
        game.setElem(0,0,16);game.setElem(0,1,4);game.setElem(0,2,4);game.setElem(0,3,0);
        game.setElem(1,0,2);game.setElem(1,1,0);game.setElem(1,2,0);game.setElem(1,3,0);
        game.setElem(2,0,2);game.setElem(2,1,0);game.setElem(2,2,2);game.setElem(2,3,0);
        game.setElem(3,0,0);game.setElem(3,1,0);game.setElem(3,2,0);game.setElem(3,3,0);

        game.motionElem(0, -1, 2, 2);
        int result[][] = {
                {16,4,4,0},
                {2,0,0,0},
                {4,0,0,0},
                {0,0,0,0},
        };
        Assertions.assertArrayEquals(result,game.getArr());

    }
    @Test
    void motionElemTest4(){
        Game game = new Game();
        game.init();
        game.setElem(0,0,16);game.setElem(0,1,4);game.setElem(0,2,4);game.setElem(0,3,0);
        game.setElem(1,0,2);game.setElem(1,1,0);game.setElem(1,2,0);game.setElem(1,3,0);
        game.setElem(2,0,2);game.setElem(2,1,0);game.setElem(2,2,2);game.setElem(2,3,0);
        game.setElem(3,0,0);game.setElem(3,1,0);game.setElem(3,2,0);game.setElem(3,3,0);

        game.motionElem(0, 1, 2, 0);
        int result[][] = {
                {16,4,4,0},
                {2,0,0,0},
                {0,0,4,0},
                {0,0,0,0},
        };
        Assertions.assertArrayEquals(result,game.getArr());

    }

}
