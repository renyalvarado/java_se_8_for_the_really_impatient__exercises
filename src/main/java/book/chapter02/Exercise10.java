package book.chapter02;

import java.util.stream.Stream;

class Average {
    final double sum;
    final int count;


    public Average() {
        this.sum = 0;
        this.count = 0;
    }

    public Average(final double sum, final int count) {
        this.sum = sum;
        this.count = count;
    }

    public Average counting(final double sum) {
        return new Average(this.sum + sum, this.count + 1);
    }

    public Average total(final Average a) {
        return new Average(this.sum + a.sum, this.count + a.count);
    }

    public double getAverage() {
        return sum / count;
    }
}

public class Exercise10 {
    public static void main(String[] args) {
        System.out.println("Exercise10");
        Average averageGenerator = Stream.of(1.0, 2.0, 3.0, 4.0)
                .reduce(new Average(), Average::counting, Average::total);
        System.out.println(averageGenerator.getAverage());
    }
}
