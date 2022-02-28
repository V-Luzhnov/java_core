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
    public static ArrayList<FileClass> fileArrayList = new ArrayList<>();
    public static final String filePath = "src/main/java/homework5/file.csv";
    public static final String title = "Value 1"+ Q_SEMICOLON + "Value 2" + Q_SEMICOLON + "Value 3" + Q_SEMICOLON + Q_NEW_LINE;

    public static void main(String[] args) throws IOException {

        createFile();
        variant1();
//        variant2();

        AppData appData = readFile();

        File file = new File(filePath);
        System.out.println(file.getName());
        System.out.println(Arrays.toString(appData.getHeader()));
        for (int [] data : appData.getData()) {
            System.out.println(Arrays.toString(data));
        }
    }

    public static void createFile(){

        Random random = new Random();
        for(int i = 1; i <= 3; i++){
            fileArrayList.add( new FileClass(random.nextInt(999), random.nextInt(999), random.nextInt(999)));
        }
    }

    public static void variant1() throws IOException {

        try (FileWriter writer = new FileWriter(filePath)){
            writer.write(title);
            for(FileClass fIleCSV : fileArrayList) {
                writer.write(fIleCSV.getValue_1() + Q_SEMICOLON + fIleCSV.getValue_2() + Q_SEMICOLON + fIleCSV.getValue_3() + Q_SEMICOLON + Q_NEW_LINE);
            }
        }
    }

    public static void variant2() throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
            //пишем первую строчку в файл
            for(byte b : title.getBytes(StandardCharsets.UTF_8)){
                fileOutputStream.write(b);
            }
            //пишем значения в остальные строки
            for(FileClass fIleCSV : fileArrayList){
                String raw = fIleCSV.getValue_1() + Q_SEMICOLON + fIleCSV.getValue_2() + Q_SEMICOLON + fIleCSV.getValue_3() + Q_SEMICOLON + Q_NEW_LINE;
                for(byte b : raw.getBytes(StandardCharsets.UTF_8)){
                    fileOutputStream.write(b);
                }
            }
        }
    }

    public static AppData readFile() throws IOException {

        AppData appData = new AppData();
        List<List<String>> fileLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            appData.setHeader(line.split(Q_SEMICOLON));
            while ((line = bufferedReader.readLine()) != null) {
                fileLines.add(Arrays.asList(line.split(Q_SEMICOLON)));
            }
        }

        int[][] resultData = new int[fileLines.size()][3];

        for(int i = 0; i < fileLines.size(); i++){
            for(int j = 0; j < fileLines.get(i).size(); j++){
                resultData[i][j] = Integer.parseInt(fileLines.get(i).get(j));
            }
        }
        appData.setData(resultData);

        return appData;
    }
}
