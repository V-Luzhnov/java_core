package homework3.exercise2;
/**
 * Java Core. Homework 3.2
 *
 * @author Vitalii Luzhnov
 * @version 21.02.2022
 */
public class RunClass {

    static final String Q_DASH = " - ";

    public static void main(String[] args) {

        Box<Fruit> box1 = addFruits(new Box<>(), new Apple(), 18);
        Box<Fruit> box2 = addFruits(new Box<>(), new Orange(), 12);
        Box<Fruit> box3 = addFruits(new Box<>(), new Orange(), 15);

        System.out.println(box1.getName() + Q_DASH + box1.getWeight());
        System.out.println(box2.getName() + Q_DASH + box2.getWeight());

        System.out.println(box1.compare(box2));

        System.out.println(box2.getName() + Q_DASH + box2.getWeight());
        System.out.println(box3.getName() + Q_DASH + box3.getWeight());

        System.out.println(box2.compare(box3));

        box3.pour(box2);

        System.out.println(box2.getName() + Q_DASH + box2.getWeight());
        System.out.println(box3.getName() + Q_DASH + box3.getWeight());

    }

    static Box<Fruit> addFruits(Box<Fruit> box, Fruit fruit, int numberOfFruit) {
        for (int i = 1; i <= numberOfFruit; i++) {
            box.add(fruit);
        }
        return box;
    }
}
