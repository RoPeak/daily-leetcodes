class Solution {
    public boolean canBeEqual(String s1, String s2) {
        return matchPair(s1, s2, 0, 2) && matchPair(s1, s2, 1, 3);
    }

    private boolean matchPair(String s1, String s2, int i, int j) {
        return (s1.charAt(i) == s2.charAt(i) && s1.charAt(j) == s2.charAt(j)) ||
               (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i));
    }
}
