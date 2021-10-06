package book.chapter02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise11 {
    public static void main(String[] args) {
        System.out.println("Exercise11");
        List<Integer> originalNumbers = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> results = Arrays.asList(new Integer[originalNumbers.size()]);
        IntStream.range(0, originalNumbers.size())
                .parallel()
                .forEach(i -> results.set(i, originalNumbers.get(i) * originalNumbers.get(i)));
        results.forEach(System.out::println);
    }
}
