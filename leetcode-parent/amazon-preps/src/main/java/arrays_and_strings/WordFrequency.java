package arrays_and_strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WordFrequency {
    public void printWordFrequency(String text) {
        var wordsToCount = Arrays.stream(text.split(" "))
                                 .filter(s -> !" ".equals(s))
                                 .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        wordsToCount.forEach((s, c) -> System.out.println(s + " " + c));
    }

    public static void main(String[] args) {
        new WordFrequency().printWordFrequency(" hello jello how are you how is it going    hello it is ok it");
    }
}
