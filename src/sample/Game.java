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

    /**
     * Сдвиг матрицы влево
     */

    public void left() {
        for(int j = 0 ; j < this.size; j++){
            for(int i = 0 ; i < this.size ; i++){
                this.motionElem(0,-1, i, j);
            }
        }
    }

    /**
     * Сдвиг матрицы вправо
     */
    public void right() {
        for(int j = this.size ; j >= 0; j--){
            for(int i = 0 ; i < this.size ; i++){
                this.motionElem(0,1, i, j);
            }
        }
    }

    /**
     * Сдвигает элемент в одну из 4х сторон <br>
     *     [0,1] - вправо;<br>
     *     [1,0] - вниз;<br>
     *     [0,-1] - влево;<br>
     *     [-1,0] - вверх;<br>
     * @param vectX направление стороны сдвига в массиве в столбце
     * @param vectY направление стороны сдвига в массиве в строке
     * @param i индекс i сдвигаемого элемента. 0 <= i <= arr.size
     * @param j индекс j сдвигаемого элемента. 0 <= i <= arr.size
     */
    public void motionElem(int vectX, int vectY, int i, int j){

        try {
            if(this.arr[i][j] == 0){        //Если сдвигаемый элемент равен нулю, то ничего не делаем
                return;
            }
            // Если в стороне сдвига пустой элемент
            if(this.arr[i + vectX][j + vectY] == 0){
                this.arr[i + vectX][j + vectY] = this.arr[i][j]; // Присваиваем пустому элементу значение текущего
                this.arr[i][j] = 0;                         // Текущий элемент теперь равен нулю
                // Теперь опять двигаем элемент(теперь уже под новым индексом) Мб он еще сдвинется
                this.motionElem(vectX, vectY, i + vectX, j + vectY);
                return;
            }
            if(this.arr[i + vectX][j + vectY] == this.arr[i][j] ){ // Если равны, то сдвигаем
                // Суммируем элементы, и присваиваем значение элементу в сторону которого идет сдвиг
                this.arr[i + vectX][j + vectY] = this.add( this.arr[i + vectX][j + vectY],  this.arr[i][j ]);
                // Текущий элемент теперь равен нулю
                this.arr[i][j] = 0;
            }
            return;


        }catch (ArrayIndexOutOfBoundsException ex){
            return;

        }
    }


}
