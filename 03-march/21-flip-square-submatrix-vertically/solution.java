class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int rowOffset = 0; rowOffset < k / 2; rowOffset++) {
            int top = x + rowOffset;
            int bottom = x + k - 1 - rowOffset;
            for (int col = y; col < y + k; col++) {
                int tmp = grid[top][col];
                grid[top][col] = grid[bottom][col];
                grid[bottom][col] = tmp;
            }
        }
        return grid;
    }
}
