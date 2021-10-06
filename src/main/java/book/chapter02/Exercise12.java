package book.chapter02;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static book.chapter02.Helper.getWordsFromWarAndPeace;

public class Exercise12 {
    public static void main(String[] args) throws IOException {
        System.out.println("Exercise12");
        AtomicInteger[] counters = new AtomicInteger[12];
        Arrays.setAll(counters, counter -> new AtomicInteger(0));
        getWordsFromWarAndPeace()
                .stream()
                .parallel()
                .filter(word -> word.length() < 12)
                .forEach(word -> counters[word.length()].getAndIncrement());
        for (int i = 0; i < counters.length; i++) {
            System.out.printf("%d: %d\n", i, counters[i].get());
        }
    }
}
