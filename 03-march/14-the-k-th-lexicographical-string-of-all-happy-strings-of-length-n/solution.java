class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char prev = 0;
        k--;

        for (int i = 0; i < n; i++) {
            int block = 1 << (n - i - 1);
            for (char ch : new char[]{'a', 'b', 'c'}) {
                if (ch == prev) {
                    continue;
                }
                if (k >= block) {
                    k -= block;
                } else {
                    sb.append(ch);
                    prev = ch;
                    break;
                }
            }
        }

        return sb.toString();
    }
}
