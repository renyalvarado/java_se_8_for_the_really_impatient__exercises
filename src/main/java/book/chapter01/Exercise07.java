package book.chapter01;

public class Exercise07 {
    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }

    public static void main(String[] args) {
        new Thread(andThen(
                () -> System.out.println("First Lambda"),
                () -> System.out.println("Second Lambda")
        )).start();
    }
}
