package arrays_and_strings;

public class BinarySearch {
    public int search(int[] nums, int target) {
        var low = 0;
        var high = nums.length - 1;
        while(high >= low){
            var mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
