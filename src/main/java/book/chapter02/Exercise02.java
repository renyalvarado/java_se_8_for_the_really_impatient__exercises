package book.chapter02;

import java.io.IOException;

import static book.chapter02.Helper.getWordsFromWarAndPeace;

public class Exercise02 {
    public static void main(String[] args) throws IOException {
        System.out.println("Exercise02");
        getWordsFromWarAndPeace()
                .stream()
                .filter(word -> word.length() > 12)
                .limit(5)
                .forEach(System.out::println);
    }
}
