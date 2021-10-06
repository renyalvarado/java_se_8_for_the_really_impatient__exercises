package book.chapter02;

import java.io.IOException;

import static book.chapter02.Helper.getWordsFromBook;

public class Exercise03 {
    public static void main(String[] args) throws IOException {
        System.out.println("Exercise03");
        long beforeParallel = System.currentTimeMillis();
        long countParallel = getWordsFromBook("war_and_peace.txt")
                .stream()
                .parallel()
                .filter(word -> word.length() > 12)
                .count();
        long afterParallel = System.currentTimeMillis();
        System.out.println("Count parallel: " + countParallel +", Time parallel: " + (afterParallel - beforeParallel));
        long before = System.currentTimeMillis();
        long countMono = getWordsFromBook("war_and_peace2.txt")
                .stream()
                .filter(word -> word.length() > 12)
                .count();
        long after = System.currentTimeMillis();
        System.out.println("Count mono: " + countMono +", Time mono: " + (after - before));
    }
}
