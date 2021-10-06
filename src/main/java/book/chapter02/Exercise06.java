package book.chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise06 {
    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            result.add(c);
        }
        return result.stream();
    }

    public static Stream<Character> characterStream2(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }

    public static void main(String[] args) {
        System.out.println("Exercise06");
        String name = "Bruno";
        characterStream(name).forEach(System.out::println);
        System.out.println("\n");
        characterStream2(name).forEach(System.out::println);
    }
}
