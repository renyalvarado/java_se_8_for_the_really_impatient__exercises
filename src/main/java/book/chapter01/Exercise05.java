package book.chapter01;

public class Exercise05 {

    public static void main(String[] args) {
        System.out.println("Exercise 05\n");
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running (class Runnable)");
            }
        };
        Thread t1 = new Thread(task1);
        t1.start();

        Thread t2 = new Thread(
                () -> System.out.println(Thread.currentThread().getName() + " is running (Lambda)")
        );
        t2.start();
    }

}
