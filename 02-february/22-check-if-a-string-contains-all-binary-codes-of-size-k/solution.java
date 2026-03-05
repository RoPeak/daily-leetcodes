class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int need = 1 << k;
        int windows = n - k + 1;
        if (windows < need) {
            return false;
        }

        boolean[] seen = new boolean[need];
        int mask = need - 1;
        int value = 0;
        int found = 0;

        for (int i = 0; i < n; i++) {
            value = ((value << 1) & mask) | (s.charAt(i) - '0');
            if (i >= k - 1 && !seen[value]) {
                seen[value] = true;
                found++;
                if (found == need) {
                    return true;
                }
            }
        }

        return false;
    }
}
