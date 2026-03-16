class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                seen.add(grid[r][c]);
                int maxSize = Math.min(Math.min(cols - 1 - c, c), (rows - 1 - r) / 2);

                for (int size = 1; size <= maxSize; size++) {
                    int total = 0;
                    int x = r;
                    int y = c;

                    for (int step = 0; step < size; step++) {
                        total += grid[x][y];
                        x++;
                        y++;
                    }
                    for (int step = 0; step < size; step++) {
                        total += grid[x][y];
                        x++;
                        y--;
                    }
                    for (int step = 0; step < size; step++) {
                        total += grid[x][y];
                        x--;
                        y--;
                    }
                    for (int step = 0; step < size; step++) {
                        total += grid[x][y];
                        x--;
                        y++;
                    }

                    seen.add(total);
                }
            }
        }

        java.util.ArrayList<Integer> sums = new java.util.ArrayList<>(seen);
        sums.sort((a, b) -> b - a);
        int limit = Math.min(3, sums.size());
        int[] ans = new int[limit];
        for (int i = 0; i < limit; i++) {
            ans[i] = sums.get(i);
        }
        return ans;
    }
}
