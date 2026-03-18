class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        long[] col = new long[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            long prefixSum = 0;
            for (int j = 0; j < n; j++) {
                col[j] += grid[i][j];
                prefixSum += col[j];   // sum of submatrix (0,0) to (i,j)
                if (prefixSum <= k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}