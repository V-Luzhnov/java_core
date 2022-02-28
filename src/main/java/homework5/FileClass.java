package homework5;
/**
 * Java Core. Homework 5
 *
 * @author Vitalii Luzhnov
 * @version 27.02.2022
 */
public class FileClass {

    private final Integer value_1;
    private final Integer value_2;
    private final Integer value_3;

    public FileClass(Integer value_1, Integer value_2, Integer value_3) {
        this.value_1 = value_1;
        this.value_2 = value_2;
        this.value_3 = value_3;
    }

    public Integer getValue_1() {
        return value_1;
    }

    public Integer getValue_2() {
        return value_2;
    }

    public Integer getValue_3() {
        return value_3;
    }
}
