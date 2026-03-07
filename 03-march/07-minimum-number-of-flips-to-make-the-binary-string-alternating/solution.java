class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int diff0 = 0;
        int diff1 = 0;
        int ans = n;

        for (int i = 0; i < 2 * n; i++) {
            char ch = s.charAt(i % n);
            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if (ch != expected0) {
                diff0++;
            }
            if (ch != expected1) {
                diff1++;
            }

            if (i >= n) {
                char left = s.charAt((i - n) % n);
                char leftExpected0 = ((i - n) % 2 == 0) ? '0' : '1';
                char leftExpected1 = ((i - n) % 2 == 0) ? '1' : '0';
                if (left != leftExpected0) {
                    diff0--;
                }
                if (left != leftExpected1) {
                    diff1--;
                }
            }

            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(diff0, diff1));
            }
        }

        return ans;
    }
}
