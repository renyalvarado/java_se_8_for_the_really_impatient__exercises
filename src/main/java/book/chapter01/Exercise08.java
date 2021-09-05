package book.chapter01;

import java.util.ArrayList;
import java.util.List;

public class Exercise08 {
    public static void main(String[] args) {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }
        runners.forEach(Runnable::run);

//        List<Runnable> runners2 = new ArrayList<>();
//        for (int i = 0; i < names.length; i++) {
//            // java: local variables referenced from a lambda expression must be final or effectively final.
//            // Compilation Error
//            runners2.add(() -> System.out.println(names[i]));
//        }
//        runners2.stream().forEach(runner -> runner.run());
    }
}
