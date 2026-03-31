class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] counts = new int[52];

        for (int i = 0; i < s1.length(); i++) {
            int offset = (i & 1) == 0 ? 0 : 26;
            counts[offset + s1.charAt(i) - 'a']++;
            counts[offset + s2.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
