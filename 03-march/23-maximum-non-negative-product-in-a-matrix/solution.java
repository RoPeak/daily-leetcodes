class Solution {
    public int maxProductPath(int[][] grid) {
        final long MOD = 1_000_000_007L;
        int m = grid.length, n = grid[0].length;

        long[][] dpMax = new long[m][n];
        long[][] dpMin = new long[m][n];

        dpMax[0][0] = dpMin[0][0] = grid[0][0];

        for (int j = 1; j < n; j++)
            dpMax[0][j] = dpMin[0][j] = dpMax[0][j - 1] * grid[0][j];
        for (int i = 1; i < m; i++)
            dpMax[i][0] = dpMin[i][0] = dpMax[i - 1][0] * grid[i][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long v = grid[i][j];
                long a = dpMax[i - 1][j] * v, b = dpMin[i - 1][j] * v;
                long c = dpMax[i][j - 1] * v, d = dpMin[i][j - 1] * v;
                dpMax[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                dpMin[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long best = dpMax[m - 1][n - 1];
        return best < 0 ? -1 : (int)(best % MOD);
    }
}
