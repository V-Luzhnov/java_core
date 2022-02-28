package homework5;
/**
 * Java Core. Homework 5
 *
 * @author Vitalii Luzhnov
 * @version 27.02.2022
 */
public class AppData {

    private String[] header;
    private int[][] data;

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }
}
