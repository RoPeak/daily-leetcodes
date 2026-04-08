class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final long MOD = 1_000_000_007L;
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = nums[i];
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2];
            long v = q[3];
            for (int idx = l; idx <= r; idx += k) {
                arr[idx] = arr[idx] * v % MOD;
            }
        }
        long xor = 0;
        for (long x : arr) xor ^= x;
        return (int) xor;
    }
}
