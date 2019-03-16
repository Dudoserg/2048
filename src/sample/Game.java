package sample;

public class Game {

    private int [][] arr;

    public int[][] getArr(){
        return this.arr;
    }

    private int size;

    public int getSize(){
        return this.size;
    }

    public Game(int size){
        this.size = size;
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
}
