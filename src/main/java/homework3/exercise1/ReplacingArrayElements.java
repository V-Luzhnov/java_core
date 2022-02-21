package homework3.exercise1;

import java.util.Arrays;
/**
 * Java Core. Homework 3.1
 *
 * @author Vitalii Luzhnov
 * @version 21.02.2022
 */
public class ReplacingArrayElements {

    static Integer[] arr1 = {1, 2, 3, 4};
    static String[] arr2 = {"1", "2", "3", "4"};
    static int index1 = 2;
    static int index2 = 3;

    public static void main(String[] args) {

        printArr(arr1);
        printArr(arr2);

    }

    static void printArr(Object[] arr) {

        ReplaceElementClass replaceElementClass = new ReplaceElementClass();

        System.out.println(Arrays.toString(arr));

        try {
            System.out.println(Arrays.toString(replaceElementClass.replaceElement(arr, index1, index2)));
        } catch (ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
        }

    }
}
