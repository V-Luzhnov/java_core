package experiments.exp2;

public class Exp2 {
    public static void main(String[] args) {

        Integer[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, 9, 8}, {7, 6, 5, 4}};
        printArr(arr);

    }
    static void printArr(Integer[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Integer[] addElementUsingPureJava(Integer[] srcArray, int elementToAdd) {
        Integer[] destArray = new Integer[srcArray.length+1];

        for(int i = 0; i < srcArray.length; i++) {
            destArray[i] = srcArray[i];
        }

        destArray[destArray.length - 1] = elementToAdd;
        return destArray;
    }
}
