package book.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Exercise09 {
    final static String[] letters = {"a", "b", "c", "d"};
    final static String[] arabicNumbers = {"0", "1", "2", "3", "4", "5", "6"};
    final static String[] romanNumbers = {"I", "II", "III", "IV", "V"};

    public static Stream<ArrayList<String>> getDefaultStream() {
        return Stream.of(
                new ArrayList<>(Arrays.asList(letters)),
                new ArrayList<>(Arrays.asList(arabicNumbers)),
                new ArrayList<>(Arrays.asList(romanNumbers))
        );
    }


    public static void main(String[] args) {
        System.out.println("Exercise09");

        Optional<ArrayList<String>> myStringList01 = getDefaultStream().reduce(
                (finalList, currentList) -> {
                    finalList.addAll(currentList);
                    return finalList;
                });
        myStringList01.ifPresent(l -> l.forEach(System.out::println));
        System.out.println();

        ArrayList<String> myStringList02 = getDefaultStream().reduce(
                new ArrayList<>(),
                (finalList, currentList) -> {
                    finalList.addAll(currentList);
                    return finalList;
                });
        myStringList02.forEach(System.out::println);
        System.out.println();

        ArrayList<String> myStringList03 = getDefaultStream().reduce(
                new ArrayList<>(),
                (finalList, currentList) -> {
                    finalList.addAll(currentList);
                    return finalList;
                },
                (finalList, currentList) -> {
                    finalList.addAll(currentList);
                    return finalList;
                });
        myStringList03.forEach(System.out::println);
    }
}
