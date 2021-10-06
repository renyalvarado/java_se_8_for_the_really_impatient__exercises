package book.chapter02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise04 {
    public static void main(String[] args) {
        System.out.println("Exercise04");
        int[] values = {1, 4, 9, 16};
        IntStream.of(values).forEach(System.out::println);
        List<Integer> boxedValues = IntStream.of(values).boxed().collect(Collectors.toList());
        System.out.println();
        for (Integer myInteger : boxedValues) {
            System.out.println("myInteger: " + myInteger);
        }
    }
}
