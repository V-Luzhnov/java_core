package homework3.exercise1;

public class ReplaceElementClass <T> {

    static <T> void replaceElementV1(T[] arr, int index1, int index2) {
        T value = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = value;
    }

    static void replaceElementV2(Object[] arr, int index1, int index2) {
        Object value = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = value;
    }
}
