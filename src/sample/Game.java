package sample;

import javax.swing.text.MutableAttributeSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game {

    /**
     * матрица поля
     */
    private int [][] arr;

    private int array_inactive[][];

    public int[][] getArray_inactive() {
        return array_inactive;
    }

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

        this.array_inactive = new int[size][size];
        for(int i = 0 ; i < size; i++)
            for(int j = 0 ; j < size; j++)
                this.array_inactive[i][j] = 0;


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
                if(this.arr[i][j] == 0){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    freePlace.add( tmp);
                }
            }
        }
        int sizeFreePlace = freePlace.size();
        //int rand = this.rand(0, sizeFreePlace);
        int rand = new Random().nextInt(freePlace.size());
        return new int[]{freePlace.get(rand).get(0), freePlace.get(rand).get(1)};
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

    public boolean left() {
        this.clearArray_inactive();
        boolean flagMotion = false;
        for(int j = 0 ; j < this.size; j++){
            for(int i = 0 ; i < this.size ; i++){
                if( this.motionElem(0,-1, i, j))
                    flagMotion = true;
            }
        }
        return flagMotion;
    }

    /**
     * Сдвиг матрицы вправо
     */
    public boolean right() {
        this.clearArray_inactive();
        boolean flagMotion = false;
        for(int j = this.size ; j >= 0; j--){
            for(int i = 0 ; i < this.size ; i++){
                if( this.motionElem(0,1, i, j) )
                    flagMotion = true;
            }
        }
        return flagMotion;
    }

    /**
     * Сдвиг матрицы вверх
     */
    public boolean up() {
        this.clearArray_inactive();
        boolean flagMotion = false;
        for(int i = 0 ; i < this.size; i++){
            for(int j = 0 ; j < this.size ; j++){
                if(  this.motionElem(-1,0, i, j))
                    flagMotion = true;
            }
        }
        return flagMotion;
    }

    /**
     * Сдвиг матрицы вниз
     */
    public boolean down() {
        this.clearArray_inactive();
        boolean flagMotion = false;
        for(int i = this.size ; i >= 0; i--){
            for(int j = 0 ; j < this.size  ; j++){
                if( this.motionElem(1,0, i, j) )
                    flagMotion = true;
            }
        }
        return flagMotion;
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
    public boolean motionElem(int vectX, int vectY, int i, int j){

        try {
            if(this.arr[i][j] == 0){        //Если сдвигаемый элемент равен нулю, то ничего не делаем
                return false;
            }
            // Если в стороне сдвига пустой элемент
            if(this.arr[i + vectX][j + vectY] == 0){
                this.arr[i + vectX][j + vectY] = this.arr[i][j]; // Присваиваем пустому элементу значение текущего
                this.arr[i][j] = 0;                         // Текущий элемент теперь равен нулю
                // Теперь опять двигаем элемент(теперь уже под новым индексом) Мб он еще сдвинется
                this.motionElem(vectX, vectY, i + vectX, j + vectY);
                return true;
            }
            // Если равны, и элемет в стороне сдвига активен, то сдвигаем
            if(this.arr[i + vectX][j + vectY] == this.arr[i][j]  && this.array_inactive[i + vectX][j + vectY] == 0){

                // Суммируем элементы, и присваиваем значение элементу в сторону которого идет сдвиг
                this.arr[i + vectX][j + vectY] = this.add( this.arr[i + vectX][j + vectY],  this.arr[i][j ]);
                // Текущий элемент теперь равен нулю
                this.arr[i][j] = 0;

                // Делаем элемент, к которому прибавили число неактивным. ДАЛЕЕ ОН НЕ МОЖЕТ ПРИНЯТЬ УЧАСТИЕ В СЛОЖЕНИИ С ДРУГИМИ ЧИСЛАМИ
                this.array_inactive[i + vectX][j + vectY] = 1;
                return true;
            }
            return false;


        }catch (ArrayIndexOutOfBoundsException ex){
            return false;

        }
    }

    /**
     * Очищаем массив неактивных блоков
     */
    public void clearArray_inactive() {
        for(int i = 0 ; i < size; i++)
            for(int j = 0 ; j < size; j++)
                this.array_inactive[i][j] = 0;
    }
}
