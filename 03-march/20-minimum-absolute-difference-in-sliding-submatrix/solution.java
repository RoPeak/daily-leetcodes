class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] ans = new int[rows - k + 1][cols - k + 1];

        for (int i = 0; i <= rows - k; i++) {
            for (int j = 0; j <= cols - k; j++) {
                java.util.HashSet<Integer> seen = new java.util.HashSet<>();
                java.util.ArrayList<Integer> values = new java.util.ArrayList<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        int val = grid[x][y];
                        if (seen.add(val)) {
                            values.add(val);
                        }
                    }
                }
                if (values.size() <= 1) {
                    ans[i][j] = 0;
                } else {
                    values.sort(java.util.Comparator.naturalOrder());
                    int diff = Integer.MAX_VALUE;
                    for (int idx = 0; idx < values.size() - 1; idx++) {
                        diff = Math.min(diff, values.get(idx + 1) - values.get(idx));
                    }
                    ans[i][j] = diff;
                }
            }
        }

        return ans;
    }
}
