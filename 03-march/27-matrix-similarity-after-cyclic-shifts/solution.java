class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        int shift = k % n;
        if (shift == 0) return true;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < n; j++) {
                int shifted = (i % 2 == 0)
                    ? mat[i][(j + shift) % n]
                    : mat[i][(j - shift + n) % n];
                if (mat[i][j] != shifted) return false;
            }
        }
        return true;
    }
}
