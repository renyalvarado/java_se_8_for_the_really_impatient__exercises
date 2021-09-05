package book.chapter01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface Collection2<T> extends Collection<T> {
    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        this.stream()
                .filter(filter)
                .forEach(action);
    }
}

class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {

}

public class Exercise09 {
    public static void main(String[] args) {
        Collection2<Integer> numbers = new ArrayList2<>();
        for (int i = 0; i < 30; i++) {
            numbers.add(i);
        }
        numbers.forEachIf(
                System.out::println,
                element -> (element % 2) == 0
        );
    }
}
