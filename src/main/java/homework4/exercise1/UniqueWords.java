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

        variant_1(); //через HashMap - пожалуй, самый оптимальный вариант

        System.out.println();

        variant_2(); //через Collectors - вполне рабочий, но по замерам времени получается в 5 дольше, чем variant_1

    }

    static void variant_1() {
        System.out.println("Вариант 1");
        System.out.println(words);
        System.out.println(new HashSet<>(words));

//        long startTime = System.currentTimeMillis();

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

//        System.out.println("Variant 2 time: " + (System.currentTimeMillis() - startTime));

        System.out.println(hashMap);

        hashMap.forEach((word, value) -> System.out.println(word + ": " + value));
    }

    static void variant_2() {
        System.out.println("Вариант 2");
        System.out.println(words);
        System.out.println(new HashSet<>(words));

//        long startTime = System.currentTimeMillis();

        Map<String, Long> map = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        System.out.println("Variant 1 time: " + (System.currentTimeMillis() - startTime));

        System.out.println(map);

        map.forEach((word, value) -> System.out.println(word + ": " + value));
    }
}
