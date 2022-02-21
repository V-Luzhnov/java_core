package homework3.exercise1;
/**
 * Java Core. Homework 3.1
 *
 * @author Vitalii Luzhnov
 * @version 21.02.2022
 */
public class ReplaceElementClass {

    public Object[] replaceElement(Object[] arr, int index1, int index2) {
        Object val = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = val;
        return arr;
    }
}
