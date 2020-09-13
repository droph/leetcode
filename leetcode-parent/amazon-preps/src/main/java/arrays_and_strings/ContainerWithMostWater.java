package arrays_and_strings;

import java.util.Queue;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        var maxArea = 0;
        if (height == null || height.length < 2) {
            return maxArea;
        }
        var left = 0;
        var right = height.length - 1;
        while (right > left) {
            var area = (right - left) * Math.min(height[right], height[left]);
            maxArea = Math.max(maxArea, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
