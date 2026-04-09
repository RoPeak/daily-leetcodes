class Solution {
    private static final long MOD = 1_000_000_007L;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = Math.max(1, (int) Math.sqrt(n));

        long[] mult = new long[n];
        java.util.Arrays.fill(mult, 1L);

        @SuppressWarnings("unchecked")
        java.util.List<int[]>[] smallQ = new java.util.ArrayList[B + 1];
        for (int i = 1; i <= B; i++) smallQ[i] = new java.util.ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if (k <= B) {
                smallQ[k].add(q);
            } else {
                for (int idx = l; idx <= r; idx += k) {
                    mult[idx] = mult[idx] * v % MOD;
                }
            }
        }

        long[] bravexuneth = new long[n];
        for (int i = 0; i < n; i++) bravexuneth[i] = nums[i];

        for (int k = 1; k <= B; k++) {
            if (smallQ[k].isEmpty()) continue;
            long[][] diff = new long[k][];
            for (int c = 0; c < k; c++) {
                int size = (n - c + k - 1) / k;
                diff[c] = new long[size + 1];
                java.util.Arrays.fill(diff[c], 1L);
            }
            for (int[] q : smallQ[k]) {
                int l = q[0], r = q[1], v = q[3];
                int c = l % k;
                int a = l / k;
                int b = a + (r - l) / k;
                diff[c][a] = diff[c][a] * v % MOD;
                diff[c][b + 1] = diff[c][b + 1] * modpow(v, MOD - 2) % MOD;
            }
            for (int c = 0; c < k; c++) {
                long prefix = 1L;
                int j = 0;
                for (int pos = c; pos < n; pos += k) {
                    prefix = prefix * diff[c][j++] % MOD;
                    mult[pos] = mult[pos] * prefix % MOD;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            result ^= bravexuneth[i] * mult[i] % MOD;
        }
        return (int) result;
    }

    private long modpow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
