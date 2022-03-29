package homework8;

import java.io.IOException;

import java.sql.SQLException;

import java.util.Scanner;

/**
 * Java Core. Homework 8
 *
 * @author Vitalii Luzhnov
 * @version 29.03.2022
 */
public class UserInterface {

    private final Controller controller = new Controller();

    public void runApplication() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print(
                    "\n1 - Добавить текущую погоду в базу данных\n" +
                    "2 - Добавить погоду на ближайшие 5 дней в базу данных\n" +
                    "3 - Получить данные из базы по дате\n" +
                    "4 - Получить все данные из базы\n" +
                    "5 - Очистить базу данных\n" +
                    "6 - Завершить работу\n" +
                    "Введите ответ: "
            );
            String result = scanner.nextLine();

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            if (result.equals("1") || result.equals("2")) {
                System.out.print("Введите название города на английском языке (exit или 6 - завершить работу): ");
                String city = scanner.nextLine();
                checkIsExit(city);
                setGlobalCity(city);
            }

            if (result.equals("3")) {
                System.out.print("Введите дату в формате YYYY-MM-DD (exit или 6 - завершить работу): ");
                String res = scanner.nextLine();
                checkIsExit(res);
                setDate(res);
            }

            try {
                notifyController(result);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

            checkIsExit(result);
        }
    }

    private void checkIsExit(String result) {
        if (result.equals("6") || result.equals("exit")) {
            System.out.println("Завершаю работу");
            System.exit(0);
        }
    }

    private void setGlobalCity(String result) {
        ApplicationGlobalState.getInstance().setSelectedCity(result);
    }

    private void setDate(String result) {
        ApplicationGlobalState.getInstance().setSelectedDate(result);
    }

    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(userInput);
            if (answer > 6){
                throw new IOException("Incorrect user input: character must be less then 5!");
            }
        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not numeric!");
        }
    }

    private void notifyController(String input) throws IOException, SQLException {
        controller.onUserInput(input);
    }

}
