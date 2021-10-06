package book.chapter02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Helper {
    public static List<String> getWordsFromBook(String book) throws IOException {
        Path warAndPeacePath = Paths.get(
                System.getProperty("user.home"),
                "Downloads",
                book
        );
        final byte[] rawFile = Files.readAllBytes(warAndPeacePath);
        String textWarAndPeace = new String(rawFile);
        return Arrays.asList(textWarAndPeace.split("[\\P{L}]+"));
    }

    public static List<String> getWordsFromWarAndPeace() throws IOException {
        return getWordsFromBook("war_and_peace.txt");
    }
}
