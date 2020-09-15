package arrays_and_strings;

public class TwoSumII {
    /*public int[] twoSum(int[] numbers, int target) {
        var numToIdx = new HashMap<Integer, Integer>();
        var result = new int[2];
        for(int idx = 0; idx < numbers.length; idx++) {
            var numToFind = target - numbers[idx];
            var numToFindIdx = numToIdx.get(numToFind);
            if(numToFindIdx != null){
                result[0] = numToFindIdx + 1;
                result[1] = idx + 1;
                return result;
            }
            numToIdx.put(numbers[idx], idx);
        }
        return result;
    }*/

    public int[] twoSum(int[] numbers, int target) {
        var low = 0;
        var high = numbers.length - 1;
        var result = new int[2];

        while(high > low) {
            var sum = numbers[low] + numbers[high];
            if(sum == target){
                result[0] = low + 1;
                result[1] = high + 1;
                return result;
            } else if (sum > target){
                high--;
            } else {
                low++;
            }
        }
        return result;
    }
}
