class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];

        int charIdx = 0;
        for (int i = 0; i < n; i++) {
            if (word[i] != 0) continue;
            if (charIdx >= 26) return "";
            word[i] = (char) ('a' + charIdx++);
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] > 0) {
                    if (word[j] != 0 && word[j] != word[i]) return "";
                    word[j] = word[i];
                }
            }
        }

        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    dp[i][j] = (i + 1 < n && j + 1 < n ? dp[i + 1][j + 1] : 0) + 1;
                }
                if (dp[i][j] != lcp[i][j]) return "";
            }
        }

        return new String(word);
    }
}
