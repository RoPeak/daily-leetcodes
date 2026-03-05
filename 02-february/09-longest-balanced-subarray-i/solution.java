import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int best = 0;

        for (int left = 0; left < n; left++) {
            Set<Integer> evenSeen = new HashSet<>();
            Set<Integer> oddSeen = new HashSet<>();

            for (int right = left; right < n; right++) {
                int value = nums[right];
                if ((value & 1) == 0) {
                    evenSeen.add(value);
                } else {
                    oddSeen.add(value);
                }

                if (evenSeen.size() == oddSeen.size()) {
                    best = Math.max(best, right - left + 1);
                }
            }
        }

        return best;
    }
}
