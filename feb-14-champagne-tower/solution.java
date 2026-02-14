class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = new double[] {poured};

        for (int r = 0; r < query_row; r++) {
            double[] next = new double[row.length + 1];
            for (int i = 0; i < row.length; i++) {
                double overflow = Math.max(0.0, row[i] - 1.0) / 2.0;
                if (overflow > 0.0) {
                    next[i] += overflow;
                    next[i + 1] += overflow;
                }
            }
            row = next;
        }

        return Math.min(1.0, row[query_glass]);
    }
}
