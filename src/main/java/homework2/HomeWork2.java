package homework2;
/**
 * Java Core. Homework 2
 *
 * @author Vitalii Luzhnov
 * @version 15.02.2022
 */
public class HomeWork2  {

    public static void main(String[] args) {
        // Массив без ошибок.
//        String[][] arr = {{"00", "01", "02", "03"}, {"10", "11", "12", "13"}, {"20", "21", "22", "23"},  {"30", "31", "32", "33"}};
        // Массив другого размера (отсутствует адрес [0][3]).
//        String[][] arr = {{"00", "01", "02"}, {"10", "11", "12", "13"}, {"20", "21", "22", "23"},  {"30", "31", "32", "33"}};
        // Массив с символами "13str" по адресу [1][3].
        String[][] arr = {{"00", "01", "02", "03"}, {"10", "11", "12", "13str"}, {"20", "21", "22", "23"},  {"30", "31", "32", "33"}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        MyTests myTests = new MyTests();

        myTests.tests(arr);

    }
}
