class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i) - 'a']++;
        }

        return Math.min(
            Math.min(counts['b' - 'a'], counts['a' - 'a']),
            Math.min(
                Math.min(counts['l' - 'a'] / 2, counts['o' - 'a'] / 2),
                counts['n' - 'a']
            )
        );
    }
}
