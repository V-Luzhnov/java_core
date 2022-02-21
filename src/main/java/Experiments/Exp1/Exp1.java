package Experiments.Exp1;

import java.util.Arrays;

public class Exp1 {

    public static void main(String[] args) {

        Integer[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 9, 8}, {7, 6, 5, 4}};
        printArr(arr);
        System.out.println();
        expArray();
        System.out.println();
        fillArray();

    }
    static void printArr(Integer[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void expArray() {
        int[] array = {1, 5, 4, 3, 7}; //объявляем и инициализируем массив
        System.out.println(array);//пытаемся вывести наш массив на экран без метода toString - получаем 16-ричное число
        System.out.println(Arrays.toString(array));//печатаем массив "правильно"
        Arrays.sort(array, 0, 4); //сортируем весь массив от нулевого до четвёртого члена
        System.out.println(Arrays.toString(array));//выводим отсортированный массив на экран
        int key = Arrays.binarySearch(array, 5); // ищем key - число 5 в отсортированном массиве.
        //метод binarySearch выдаст индекс элемента остортированного массива, в котором "спрятано" искомое число
        System.out.println(key);//распечатываем индекс искомого числа
        System.out.println(Arrays.binarySearch(array, 0));//а теперь попробуем найти число, которого в массиве нет, и сразу же выведем результат на экран
    }

    static int[] fillArray() {
        int[] array = new int[8];
        for (int i = 0, j = 0; i < array.length; i++, j += 3)
            array[i] = j;
        return array;
    }
}
