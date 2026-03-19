class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int cols = grid[0].length;
        int[] xCol = new int[cols];
        int[] yCol = new int[cols];
        int ans = 0;

        for (char[] row : grid) {
            int xPrefix = 0;
            int yPrefix = 0;

            for (int c = 0; c < cols; c++) {
                if (row[c] == 'X') {
                    xCol[c]++;
                } else if (row[c] == 'Y') {
                    yCol[c]++;
                }

                xPrefix += xCol[c];
                yPrefix += yCol[c];

                if (xPrefix > 0 && xPrefix == yPrefix) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
