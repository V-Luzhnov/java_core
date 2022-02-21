package homework3.exercise1;

import java.util.Arrays;
/**
 * Java Core. Homework 3.1
 *
 * @author Vitalii Luzhnov
 * @version 16.02.2022
 */
public class ReplacingArrayElements {

    static Integer[] arr = {1, 2, 3, 4};
    static int index1 = 2;
    static int index2 = 3;

    public static void main(String[] args) {

        ReplaceElementClass<Object> replaceElementClass = new ReplaceElementClass<>();

        System.out.println(Arrays.toString(arr));
        try {
            System.out.println(Arrays.toString(replaceElementClass.replaceElementV1(arr, index1, index2)));
        } catch (ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
        }

//        replaceElementV2(arr, index1, index2);
//        System.out.println(Arrays.toString(arr));
    }

//    static void replaceElementV2(Object[] arr, int index1, int index2) {
//        Object val = arr[index1];
//        arr[index1] = arr[index2];
//        arr[index2] = val;
//    }
}
