package book.chapter01;

import java.io.File;
import java.util.Arrays;

public class Exercise04 {


    static File[] getSubDirectories(final File parentDirectory) {
        return parentDirectory.listFiles(
                (file, filename) -> file.isDirectory()
        );
    }

    public static void main(String[] args) {
        System.out.println("Exercise 04\n");
        String strHomeDirectory = System.getProperty("user.home");
        File homeDirectory = new File(strHomeDirectory, "Downloads");

        System.out.println("getSubDirectories:");
        Arrays.stream(getSubDirectories(homeDirectory))
                .sorted((f1, f2) -> {
                    if (f1.isDirectory() && !f2.isDirectory()) {
                        return -1;
                    }
                    if (!f1.isDirectory() && f2.isDirectory()) {
                        return 1;
                    }
                    return f1.getName().compareToIgnoreCase(f2.getName());
                })
                .forEachOrdered(System.out::println);
    }
}
