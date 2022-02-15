package homework2;

import static java.lang.Integer.parseInt;
/**
 * Java Core. Homework 2
 *
 * @author Vitalii Luzhnov
 * @version 15.02.2022
 */
public class MyTests {

    public void tests(String[][] arr) {

        System.out.println("Start Test \"Array Size\".");
        try {
            testArraySize(4,arr);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        };
        System.out.println("Test \"Array Size\" complete.");

        System.out.println("Start Test \"Data Exception\".");
        try {
            testDataException(arr);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        };
        System.out.println("Test \"Data Exception\" complete.");
    }

    public void testArraySize(int size, String[][] arr) throws MyArraySizeException {
        if(size != arr.length || size != arr[0].length) {
            throw new MyArraySizeException("The size of the array does not match the condition.");
        }
    }

    public void testDataException(String[][] arr) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (conversionPossible(arr[i][j])) {
                    sum += parseInt(arr[i][j].trim());
                } else{
                    throw new MyArrayDataException("The value at address [" + i + "][" + j + "] is not a number.");
                };
            }
        }
        System.out.println("Sum = " + sum);
    }

    boolean conversionPossible(String str) {
        String charactersToSearch = "0123456789";
        for (int i = 0, n = str.length(); i < n; i++) {
            int index = charactersToSearch.indexOf(str.charAt(i));
            if (index == -1){
                return false;
            }
        }
        return true;
    }
}
