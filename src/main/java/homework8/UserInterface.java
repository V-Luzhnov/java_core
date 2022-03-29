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
            System.out.print("Введите название города на английском языке (exit - завершить работу): ");
            String city = scanner.nextLine();

            checkIsExit(city);
            setGlobalCity(city);

            System.out.print("1 - Получить текущую погоду\n" +
                    "2 - Получить погоду на ближайшие 5 дней\n" +
                    "3 - Получить погоду из базы данных\n" +
                    "4 - Завершить работу\n" +
                    "Введите ответ: ");
            String result = scanner.nextLine();

            checkIsExit(result);

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(result);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void checkIsExit(String result) {
        if (result.toLowerCase().equals("4") || result.toLowerCase().equals("exit")) {
            System.out.println("Завершаю работу");
            System.exit(0);
        }
    }

    private void setGlobalCity(String result) {
        ApplicationGlobalState.getInstance().setSelectedCity(result);
    }

    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(userInput);
            if (answer >= 5){
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
