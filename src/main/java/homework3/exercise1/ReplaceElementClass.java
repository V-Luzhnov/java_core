package homework3.exercise1;
/**
 * Java Core. Homework 3.1
 *
 * @author Vitalii Luzhnov
 * @version 21.02.2022
 */
public class ReplaceElementClass <T> {

    public T[] replaceElementV1(T[] arr, int index1, int index2) {
        T value = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = value;
        return arr;
    }
}
