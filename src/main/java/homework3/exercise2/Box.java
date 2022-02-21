package homework3.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Java Core. Homework 3.2
 *
 * @author Vitalii Luzhnov
 * @version 21.02.2022
 */
public class Box<T extends Fruit> {

    T[] fruitArray;
    ArrayList<T> fruitList;

    public Box(T[] fruitArray, ArrayList<T> fruitList) {
        this.fruitArray = fruitArray;
        this.fruitList = fruitList;
    }

    //Переопределяем конструктор для неограниенного числа входящих параметров
    public Box(T...fruit) {
        //Разворачиваем массив в список
        this.fruitList = new ArrayList<>(Arrays.asList(fruit));
    }

    public String getName() {
        for (T fruit : fruitList) {
            return fruit.getName();
        }
        return "Empty";
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruitList) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void pour(Box<T> fruits) {
        fruits.fruitList.addAll(fruitList);
        fruitList.clear();
    }

    public void add(T fruit) {
        fruitList.add(fruit);
    }

    public boolean compare(Box<? extends Fruit> fruits) {
        return this.getWeight() == fruits.getWeight();
    }
}
