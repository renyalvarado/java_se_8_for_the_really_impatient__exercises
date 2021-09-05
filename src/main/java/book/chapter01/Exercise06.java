package book.chapter01;

@FunctionalInterface
interface RunnableEx {
    void run() throws Exception;
}

public class Exercise06 {
    public static void main(String[] args) {
        System.out.println("Exercise 06\n");
        new Thread(uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        })
        ).start();
    }

    public static Runnable uncheck(RunnableEx runnableEx) {
        return () -> {
            try {
                runnableEx.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
