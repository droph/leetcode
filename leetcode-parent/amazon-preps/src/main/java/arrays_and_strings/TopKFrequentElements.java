package arrays_and_strings;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        var countByVal = Arrays.stream(nums)
                               .boxed()
                               .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        var queue = new PriorityQueue<Integer>(k + 1,
                (n1, n2) -> (int) (countByVal.get(n1) - countByVal.get(n2)));
        for (Integer num : countByVal.keySet()) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        var result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
