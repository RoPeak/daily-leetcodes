import java.util.Arrays;

class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0];
        int[] rest = Arrays.copyOfRange(nums, 1, nums.length);
        Arrays.sort(rest);
        return first + rest[0] + rest[1];
    }
}
