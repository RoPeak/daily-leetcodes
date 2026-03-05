class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long NEG = (long) -1e18;
        long[] inc = new long[n];
        long[] dec = new long[n];
        long[] tri = new long[n];
        for (int i = 0; i < n; i++) {
            inc[i] = NEG;
            dec[i] = NEG;
            tri[i] = NEG;
        }

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                inc[i] = Math.max(inc[i - 1] + nums[i], (long) nums[i - 1] + nums[i]);
            }

            if (nums[i - 1] > nums[i]) {
                if (inc[i - 1] > NEG) dec[i] = Math.max(dec[i], inc[i - 1] + nums[i]);
                if (dec[i - 1] > NEG) dec[i] = Math.max(dec[i], dec[i - 1] + nums[i]);
            }

            if (nums[i - 1] < nums[i]) {
                if (dec[i - 1] > NEG) tri[i] = Math.max(tri[i], dec[i - 1] + nums[i]);
                if (tri[i - 1] > NEG) tri[i] = Math.max(tri[i], tri[i - 1] + nums[i]);
            }
        }

        long best = tri[0];
        for (int i = 1; i < n; i++) best = Math.max(best, tri[i]);
        return best;
    }
}
