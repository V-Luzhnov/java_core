package homework3.exercise1;

import java.util.Arrays;
/**
 * Java Core. Homework 3.1
 *
 * @author Vitalii Luzhnov
 * @version 16.02.2022
 */
public class ReplacingArrayElements <T>{

    public static void main(String[] args) {
        int index1 = 2;
        int index2 = 3;
        Object[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
        ReplaceElementClass.replaceElementV1(arr, index1, index2);
        System.out.println(Arrays.toString(arr));
//        ReplaceElementClass.replaceElementV2(arr, index1, index2);
//        System.out.println(Arrays.toString(arr));
    }
}
