package sample;

import javax.swing.text.MutableAttributeSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    /**
     * матрица поля
     */
    private int [][] arr;

    /**
     * Размер матрицы поля
     */
    private int size;

    /**
     * Конструктор для создания класса Game.
     * @param size параметр, который задает размер матрицы поля.
     */
    public Game(int size){
        this.size = size;
    }

    /**
     * Конструктор для создания класса Game. Без параметров
     */
    public Game(){
        this.size = 4;
    }

    /**
     * Метод для получения матрицы поля
     * @return массив типа int, размером size*size
     */
    public int[][] getArr(){
        return this.arr;
    }

    /**
     * Метод для получения размера матрицы
     * @return размер матрицы (int)
     */
    public int getSize(){
        return this.size;
    }

    public void setElem(int i, int j, int num) {

        this.arr[i][j] = num;
    }

    public int getElem(int i, int j) {

        return this.arr[i][j];
    }


    public  void init() {
        this.arr = new int[size][size];
        for(int i = 0 ; i < size; i++)
            for(int j = 0 ; j < size; j++)
                this.arr[i][j] = 0;
    }



    /**
     * Суммирование двух чисел
     * @param a Число кратное 2 (2,4,8,16...)
     * @param b Число кратное 2 (2,4,8,16...)
     * @return сумма двух чисел
     */
    public int add(int a, int b) {

       return a+b;
    }



    /**
     * Метод по генерации числа для вставки. 2 или 4 с вероятностью 90% и 10% соответственно
     * @return число : 2 или 4 с вероятностью 90% и 10% соответственно
     */
    public int generateNumber() {
        double rand =  Math.random();
        if(rand < 0.1)
            return 4;
        return 2;
    }




    /**
     * Получаем случайным образом индекс свободного места в массиве
     * @return массив int. Первый элемент - строка, второй элемент столбец. Нумерация начинается с 0;
     */
    public int[] findFreePlace() {
        ArrayList<ArrayList<Integer>> freePlace = new ArrayList<>();
        for(int i = 0 ; i < this.size; i++){
            for(int j = 0 ; j < this.size; j++){
                if(this.arr[i][j] == 0)
                    freePlace.add( new ArrayList(Arrays.asList(i,j)));
            }
        }
        int sizeFreePlace = freePlace.size();
        int rand = this.rand(0, sizeFreePlace);
        return new int[]{freePlace.get(rand).get(0), freePlace.get(rand).get(0)};
    }



    /**
     * Генерирование случайным образом числа в диапазоне [from,to)
     * @param from число которой обозначает начала диапазона, from < to
     * @param to число которой обозначает конец диапазона, to > from
     * @return целое число в диапазоне [from,to)
     */
    public int rand(int from, int to){
        return from + (int) (Math.random() * to);
    }


    public void left() {
        // todo реализовать нормальный сдвиг влево
        this.arr =  new int [][] {
                {16,8,0,0},
                {2,0,0,0},
                {4,0,0,0},
                {0,0,0,0},
        };
    }

    public void motionElem(int vectX, int vectY, int i, int j){
        // todo реализовать нормальный сдвиг элемента по верктору (vectX,vectY)
        this.arr =  new int [][] {
                {16,8,0,0},
                {2,0,0,0},
                {2,0,2,0},
                {0,0,0,0},
        };
    }

}
