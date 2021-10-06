package book.chapter02;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static book.chapter02.Helper.getWordsFromWarAndPeace;

public class Exercise01 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Exercise01");
        Runtime runtime = Runtime.getRuntime();
        int availableProcessors = runtime.availableProcessors();
        System.out.println("Processors: " + availableProcessors);
        try {
            List<String> words = getWordsFromWarAndPeace();
            System.out.println("total words: " + words.size());
            final double step = (double) words.size() / availableProcessors;
            Thread[] threads = new Thread[availableProcessors];
            BlockingQueue<Long> queue = new ArrayBlockingQueue<>(availableProcessors);
            for (int i = 0; i < availableProcessors; i++) {
                final int n = i;
                threads[i] = new Thread(() -> {
                    final long[] getInterval = getInterval(n, step);
                    final int begin = (int) getInterval[0];
                    final int end = (int) getInterval[1];
                    System.out.println("n: " + n + "[" + begin + ", " + end + ") = " + (end - begin));
                    long count = words.subList(begin, end).stream().filter(w -> w.length() > 12).count();
                    queue.add(count);
                });
            }
            for (Thread thread : threads) {
                thread.start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            long totalWithThreads = 0;
            while (!queue.isEmpty()) {
                Long totalSingleThread = queue.poll();
                totalWithThreads += totalSingleThread;
            }
            long count = words.stream().filter(w -> w.length() > 12).count();
            System.out.println("totalWithThreads: " + totalWithThreads);
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static long[] getInterval(int intervalNumber, double step) {
        double begin = intervalNumber * step;
        double end = begin + step;
        return new long[]{Math.round(begin), Math.round(end)};
    }
}
