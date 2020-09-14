package arrays_and_strings;

import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if("".equals(s)) {
            return s;
        }
        var charToCount = s.chars()
                           .mapToObj(i -> (char)i)
                           .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        var heap = new PriorityQueue<Character>(s.length(), (c1, c2) -> (int)(charToCount.get(c2) - charToCount.get(c1)));

        heap.addAll(charToCount.keySet());

        var builder = new StringBuilder();
        Character currChar = heap.poll();
        while(currChar != null){
            var num = charToCount.get(currChar);
            for(int i = 0; i < num; i++){
                builder.append(currChar);
            }
            currChar = heap.poll();
        }
        return builder.toString();
    }
}
