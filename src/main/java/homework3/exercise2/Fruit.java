package homework3.exercise2;
/**
 * Java Core. Homework 3.2
 *
 * @author Vitalii Luzhnov
 * @version 21.02.2022
 */
public abstract class Fruit {

    private final String name;
    private final float weight;

    public Fruit(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    String getName() {
        return name;
    }

    float getWeight() {
        return weight;
    }
}
