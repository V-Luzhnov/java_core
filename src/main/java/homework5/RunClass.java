package homework5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Java Core. Homework 5
 *
 * @author Vitalii Luzhnov
 * @version 27.02.2022
 */
public class RunClass {

    static final String Q_NEW_LINE = "\n";
    static final String Q_SEMICOLON = ";";
    public static ArrayList<RowClass<Serializable>> fileArrayList = new ArrayList<>();
    public static final String file1Path = "src/main/java/homework5/file1.csv";
    public static final String file2Path = "src/main/java/homework5/file2.csv";
    static final String Q_VALUE = "Value ";

    public static void main(String[] args) throws IOException {
        createRow(); //создаем строки данных для *.csv
        writeFile1(); //пишем данные в file1.csv через FileOutputStream
        writeFile2(); //пишем данные в file2.csv через FileWriter
        AppData appData = readFile(); //читаем данные из file1.csv и помещаем их в объект AppData
        printAppData(appData); //выводим в консоль содержимое объекта AppData
        changeHeaderAppData(appData); //меняем значения первой строки (header) в объекте AppData
        printAppData(appData); //выводим в консоль содержимое объекта AppData
        save(appData); //копируем данные из объекта AppData в file1.csv (перезаписываем file.csv через FileWriter)
    }

    public static void createRow() {
        fileArrayList.add(new RowClass<>(Q_VALUE + 1, Q_VALUE + 2, Q_VALUE + 3));
        Random random = new Random();
        for (int i = 1; i <= 3; i++) {
            fileArrayList.add(new RowClass<>(random.nextInt(999), random.nextInt(999), random.nextInt(999)));
        }
    }

    public static void writeFile1() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file1Path)){
            for(var row : fileArrayList){
                String raw = row.getValue_1() + Q_SEMICOLON + row.getValue_2() + Q_SEMICOLON + row.getValue_3() + Q_SEMICOLON + Q_NEW_LINE;
                for(byte b : raw.getBytes(StandardCharsets.UTF_8)){
                    fileOutputStream.write(b);
                }
            }
        }
    }

    public static void writeFile2() throws IOException {
        try (FileWriter writer = new FileWriter(file2Path)){
            for(var row : fileArrayList) {
                writer.write(row.getValue_1() + Q_SEMICOLON + row.getValue_2() + Q_SEMICOLON + row.getValue_3() + Q_SEMICOLON + Q_NEW_LINE);
            }
        }
    }

    public static AppData readFile() throws IOException {
        AppData appData = new AppData();
        List<List<String>> fileLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1Path))) {
            String line = bufferedReader.readLine();
            appData.setHeader(line.split(Q_SEMICOLON));
            while ((line = bufferedReader.readLine()) != null) {
                fileLines.add(Arrays.asList(line.split(Q_SEMICOLON)));
            }
        }

        int[][] resultData = new int[fileLines.size()][3];

        for (int i = 0; i < fileLines.size(); i++) {
            for (int j = 0; j < fileLines.get(i).size(); j++) {
                resultData[i][j] = Integer.parseInt(fileLines.get(i).get(j));
            }
        }
        appData.setData(resultData);

        return appData;
    }

    public static void printAppData(AppData appData) {
        System.out.println(Arrays.toString(appData.getHeader()));
        for (int[] data : appData.getData()) {
            System.out.println(Arrays.toString(data));
        }
    }

    public static void changeHeaderAppData(AppData appData) {
        appData.setHeader(new String[]{Q_VALUE + 11 + Q_SEMICOLON + Q_VALUE + 22 + Q_SEMICOLON + Q_VALUE + 33});
    }

    public static void save(AppData data) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file1Path)) {

            StringBuilder valveHeader = new StringBuilder();
            for (String value : data.getHeader()) {
                valveHeader.append(value).append(Q_SEMICOLON);
            }
            fileWriter.write(valveHeader + Q_NEW_LINE);

            for (int[] row : data.getData()) {
                StringBuilder valveData = new StringBuilder();
                for (int value : row) {
                    valveData.append(value).append(Q_SEMICOLON);
                }
                fileWriter.write(valveData + Q_NEW_LINE);
            }
        }
    }
}
