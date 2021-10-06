package book.chapter02;

import java.util.stream.Stream;

public class Exercise05 {
    public static Stream<Long> congruentialGenerator(long a, long c, long m, long seed) {
        return Stream.iterate(seed, n -> ((a * n) + c) % m);
    }

    public static void main(String[] args) {
        System.out.println("Exercise05");
        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2, 48);
        congruentialGenerator(a, c, m, 0).limit(10).forEach(System.out::println);
    }
}
