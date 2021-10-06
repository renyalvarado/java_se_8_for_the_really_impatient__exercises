package book.chapter02;

import java.util.stream.Stream;

public class Exercise07 {
    /* https://en.wikipedia.org/wiki/Halting_problem */
    public static <T> boolean isFinite(Stream<T> stream) {
        return stream.spliterator().estimateSize() < Long.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println("Exercise07");
        System.out.println(isFinite(Stream.of(1, 2, 3)));
    }
}
