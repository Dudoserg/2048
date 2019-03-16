package sample;

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


    public  void init() {
        this.arr = new int[2][2];
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

    public void setElem(int i, int j, int num) {
        this.arr[i][j] = num;
    }

    public int getElem(int i, int j) {
        return this.arr[i][j];
    }

    public int[] findFreePlace() {
        return new int[]{3,3};
    }
}
