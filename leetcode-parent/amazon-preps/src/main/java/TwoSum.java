import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {
    public static List<Integer> calculate(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return List.of();
        }

        var valueToIndex = IntStream.range(0, nums.length)
                                    .boxed()
                                    .collect(groupingBy(idx -> nums[idx]));

        for (int firstIdx = 0; firstIdx < nums.length; firstIdx++) {
            var firstValue = nums[firstIdx];
            var secondValue = target - firstValue;
            var secondIndices = valueToIndex.get(secondValue);
            if (secondIndices != null) {
                for (int secondIdx : secondIndices){
                    if (secondIdx != firstIdx) {
                        return List.of(firstIdx, secondIdx);
                    }
                }
            }
        }
        return List.of();
    }
}
