class Solution {
    public int minimumDeletions(String s) {
        int countB = 0;
        int deletions = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'b') {
                countB++;
            } else {
                deletions = Math.min(deletions + 1, countB);
            }
        }

        return deletions;
    }
}
