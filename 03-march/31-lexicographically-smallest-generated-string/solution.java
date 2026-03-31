class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length(), L = n + m - 1;
        char[] word = new char[L];
        boolean[] locked = new boolean[L];
        java.util.Arrays.fill(word, 'a');

        // Stamp str2 at all 'T' positions
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    char c = str2.charAt(j);
                    if (locked[pos] && word[pos] != c) return "";
                    word[pos] = c;
                    locked[pos] = true;
                }
            }
        }

        // Fix 'F' windows that match str2
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) { match = false; break; }
                }
                if (match) {
                    boolean fixed = false;
                    for (int j = m - 1; j >= 0; j--) {
                        if (!locked[i + j]) {
                            word[i + j] = 'b';
                            fixed = true;
                            break;
                        }
                    }
                    if (!fixed) return "";
                }
            }
        }

        // Final validation
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) { match = false; break; }
                }
                if (match) return "";
            }
        }

        return new String(word);
    }
}
