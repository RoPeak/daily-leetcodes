class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int n = grid.length, m = grid[0].length, N = n * m;

        int[] flat = new int[N];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                flat[i * m + j] = grid[i][j];

        int[] result = new int[N];

        int prefix = 1;
        for (int k = 0; k < N; k++) {
            result[k] = prefix;
            prefix = prefix * (flat[k] % MOD) % MOD;
        }

        int suffix = 1;
        for (int k = N - 1; k >= 0; k--) {
            result[k] = result[k] * suffix % MOD;
            suffix = suffix * (flat[k] % MOD) % MOD;
        }

        int[][] out = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                out[i][j] = result[i * m + j];
        return out;
    }
}
