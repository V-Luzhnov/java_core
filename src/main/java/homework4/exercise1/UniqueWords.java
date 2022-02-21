package homework4.exercise1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Java Core. Homework 4.1
 *
 * @author Vitalii Luzhnov
 * @version 21.02.2022
 */
public class UniqueWords {

    static final List<String> words =
            Arrays.asList("fault", "spanner", "cocktail", "castle", "spanner", "basket", "spanner", "latch", "castle", "pitcher");


    public static void main(String[] args) {

        variant_1(); //пожалуй, самый оптимальный вариант

        System.out.println();

        variant_2(); //вполне рабочий, но почему-то по замерам времени получается в 5 дольше, чем variant_1

    }

    static void variant_1() {
        System.out.println("Вариант 2");
        System.out.println(words);
        System.out.println(new HashSet<>(words));

//        long startTime = System.currentTimeMillis();

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

//        System.out.println("Variant 2 time: " + (System.currentTimeMillis() - startTime));

        System.out.println(map);

        map.forEach((word, count) -> System.out.println(word + ": " + count));
    }

    static void variant_2() {
        System.out.println("Вариант 1");
        System.out.println(words);
        System.out.println(new HashSet<>(words));

//        long startTime = System.currentTimeMillis();

        Map<String, Long> map = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        System.out.println("Variant 1 time: " + (System.currentTimeMillis() - startTime));

        System.out.println(map);

        map.forEach((K, V) -> System.out.println(K + ": " + V));
    }
}
