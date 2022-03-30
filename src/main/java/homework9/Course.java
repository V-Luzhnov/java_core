package homework9;

/**
 * Java Core. Homework 9
 *
 * @author Vitalii Luzhnov
 * @version 30.03.2022
 */
public class Course implements Courses{

    private final String name;

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
