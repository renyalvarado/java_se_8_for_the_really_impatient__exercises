package book.chapter01;

import java.io.File;
import java.util.Arrays;

public class Exercise03 {

    static File[] getSubDirectories(final File parentDirectory, final String extension) {
        return parentDirectory.listFiles(
                (file, filename) -> file.isDirectory() && filename.endsWith(extension)
        );
    }

    public static void main(String[] args) {
        System.out.println("Exercise 03\n");
        String strHomeDirectory = System.getProperty("user.home");
        File homeDirectory = new File(strHomeDirectory, "Downloads");

        System.out.println("getSubDirectories:");
        Arrays.stream(getSubDirectories(homeDirectory, ".pdf"))
                .forEachOrdered(System.out::println);
    }
}
