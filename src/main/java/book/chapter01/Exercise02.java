package book.chapter01;

import java.io.File;
import java.util.Arrays;

public class Exercise02 {
    static File[] getSubDirectories(File parentDirectory) {
        return parentDirectory.listFiles(File::isDirectory);
    }

    static File[] getSubDirectoriesMethodExpression(File parentDirectory) {
        return parentDirectory.listFiles(File::isDirectory);
    }

    public static void main(String[] args) {
        System.out.println("Exercise 02\n");
        String strHomeDirectory = System.getProperty("user.home");
        File homeDirectory = new File(strHomeDirectory, "Downloads");

        System.out.println("getSubDirectories:");
        for (File file : getSubDirectories(homeDirectory)) {
            System.out.println(file);
        }
        System.out.println();

        System.out.println("getSubDirectoriesMethodExpression:");
        for (File file : getSubDirectoriesMethodExpression(homeDirectory)) {
            System.out.println(file);
        }
        System.out.println();

        System.out.println("getSubDirectoriesMethodExpression + stream:");
        Arrays.stream(getSubDirectoriesMethodExpression(homeDirectory))
                .forEachOrdered(System.out::println);
    }
}
