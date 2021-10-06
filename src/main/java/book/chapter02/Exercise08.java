package book.chapter02;

import java.util.Iterator;
import java.util.stream.Stream;

public class Exercise08 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        Stream.Builder<T> builder = Stream.builder();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            builder.accept(firstIterator.next());
            builder.accept(secondIterator.next());
        }
        return builder.build();
    }

    public static void main(String[] args) {
        System.out.println("Exercise08");
        zip(
                Stream.of("a", "b", "c", "d", "e"),
                Stream.of("1", "2", "3")
        ).forEach(System.out::println);
    }
}
