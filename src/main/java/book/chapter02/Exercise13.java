package book.chapter02;

import java.io.IOException;
import java.util.stream.Collectors;

import static book.chapter02.Helper.getWordsFromWarAndPeace;

public class Exercise13 {
    public static void main(String[] args) throws IOException {
        System.out.println("Exercise13");
        getWordsFromWarAndPeace()
                .stream()
                .parallel()
                .filter(word -> word.length() < 12)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
