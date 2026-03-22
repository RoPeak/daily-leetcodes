class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int rotation = 0; rotation < 4; rotation++) {
            if (equal(mat, target)) {
                return true;
            }
            mat = rotate(mat, n);
        }
        return false;
    }

    private boolean equal(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] rotate(int[][] matrix, int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = matrix[n - 1 - j][i];
            }
        }
        return res;
    }
}
