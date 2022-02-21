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

        Box<Apple> box1 = new Box<>();
        addApple(box1, 18);

        Box<Orange> box2 = new Box<>();
        addOrange(box2, 12);

        Box<Orange> box3 = new Box<>();
        addOrange(box3, 13);

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

    static void addApple(Box<Apple> box, int numberOfFruit) {
        for (int i = 1; i <= numberOfFruit; i++) {
            box.add(new Apple());
        }
    }

    static void addOrange(Box<Orange> box, int numberOfFruit) {
        for (int i = 1; i <= numberOfFruit; i++) {
            box.add(new Orange());
        }
    }
}
