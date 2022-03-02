package homework5;
/**
 * Java Core. Homework 5
 *
 * @author Vitalii Luzhnov
 * @version 27.02.2022
 */
public class RowClass <T>{

    private final T value_1, value_2, value_3;

    public RowClass(T value_1, T value_2, T value_3) {
        this.value_1 = value_1;
        this.value_2 = value_2;
        this.value_3 = value_3;
    }

    public T getValue_1() {
        return value_1;
    }

    public T getValue_2() {
        return value_2;
    }

    public T getValue_3() {
        return value_3;
    }
}
