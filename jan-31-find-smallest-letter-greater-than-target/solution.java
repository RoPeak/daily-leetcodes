class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (letters[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == letters.length ? letters[0] : letters[lo];
    }
}
