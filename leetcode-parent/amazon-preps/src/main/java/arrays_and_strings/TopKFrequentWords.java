package arrays_and_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        var wordToCount = new HashMap<String, Integer>();
        for (int idx = 0; idx < words.length; idx++) {
            wordToCount.put(words[idx], wordToCount.getOrDefault(words[idx], 0) + 1);
        }
        var heap = new PriorityQueue<String>(k + 1, (s1, s2) -> {
            var diff = wordToCount.get(s1) - wordToCount.get(s2);
            if (diff == 0) {
                return s2.compareTo(s1);
            }
            return diff;
        });

        for (String word : wordToCount.keySet()) {
            heap.add(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        var result = new ArrayList<String>(k);
        for (int idx = 0; idx < k; idx++) {
            result.add(0, heap.poll());
        }
        return result;
    }
}
