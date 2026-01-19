class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] ps = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = mat[i - 1][j - 1] + ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
            }
        }

        int lo = 0;
        int hi = Math.min(m, n);
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            boolean ok = false;
            for (int i = 0; i + mid <= m && !ok; i++) {
                for (int j = 0; j + mid <= n; j++) {
                    int sum = ps[i + mid][j + mid] - ps[i][j + mid] - ps[i + mid][j] + ps[i][j];
                    if (sum <= threshold) {
                        ok = true;
                        break;
                    }
                }
            }
            if (ok) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }
}
