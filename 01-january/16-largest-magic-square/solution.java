class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        int[][] d1 = new int[m + 1][n + 1];
        int[][] d2 = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                row[i][j + 1] = row[i][j] + val;
                col[i + 1][j] = col[i][j] + val;
                d1[i + 1][j + 1] = d1[i][j] + val;
                d2[i + 1][j] = d2[i][j + 1] + val;
            }
        }

        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int r = 0; r <= m - k; r++) {
                for (int c = 0; c <= n - k; c++) {
                    int target = rowSum(row, r, c, k);
                    if (diag1Sum(d1, r, c, k) != target || diag2Sum(d2, r, c, k) != target) {
                        continue;
                    }
                    boolean ok = true;
                    for (int i = r; i < r + k; i++) {
                        if (rowSum(row, i, c, k) != target) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;
                    for (int j = c; j < c + k; j++) {
                        if (colSum(col, r, j, k) != target) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) return k;
                }
            }
        }
        return 1;
    }

    private int rowSum(int[][] row, int i, int c, int k) {
        return row[i][c + k] - row[i][c];
    }

    private int colSum(int[][] col, int r, int j, int k) {
        return col[r + k][j] - col[r][j];
    }

    private int diag1Sum(int[][] d1, int r, int c, int k) {
        return d1[r + k][c + k] - d1[r][c];
    }

    private int diag2Sum(int[][] d2, int r, int c, int k) {
        return d2[r + k][c] - d2[r][c + k];
    }
}
