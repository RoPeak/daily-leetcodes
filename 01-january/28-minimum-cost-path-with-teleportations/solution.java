class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int maxVal = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > maxVal) maxVal = grid[i][j];
            }
        }
        long INF = (long) 1e18;

        long[][] dist = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) dist[i][j] = INF;
        }
        dist[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                long best = INF;
                if (i > 0) best = Math.min(best, dist[i - 1][j] + grid[i][j]);
                if (j > 0) best = Math.min(best, dist[i][j - 1] + grid[i][j]);
                dist[i][j] = best;
            }
        }

        for (int step = 0; step < k; step++) {
            long[] minByVal = new long[maxVal + 1];
            for (int v = 0; v <= maxVal; v++) minByVal[v] = INF;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int v = grid[i][j];
                    if (dist[i][j] < minByVal[v]) minByVal[v] = dist[i][j];
                }
            }

            long[] suffix = new long[maxVal + 2];
            for (int v = 0; v <= maxVal + 1; v++) suffix[v] = INF;
            for (int v = maxVal; v >= 0; v--) {
                suffix[v] = Math.min(minByVal[v], suffix[v + 1]);
            }

            long[][] newDist = new long[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newDist[i][j] = Math.min(dist[i][j], suffix[grid[i][j]]);
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        if (newDist[i][j] > 0) newDist[i][j] = 0;
                        continue;
                    }
                    long best = newDist[i][j];
                    if (i > 0) best = Math.min(best, newDist[i - 1][j] + grid[i][j]);
                    if (j > 0) best = Math.min(best, newDist[i][j - 1] + grid[i][j]);
                    newDist[i][j] = best;
                }
            }

            dist = newDist;
        }

        return (int) dist[m - 1][n - 1];
    }
}
