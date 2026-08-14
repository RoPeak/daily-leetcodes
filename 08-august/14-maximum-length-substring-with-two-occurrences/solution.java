class Solution {
    public int maximumLengthSubstring(String s) {
        int[] counts = new int[26];
        int left = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'a';
            counts[idx]++;

            while (counts[idx] > 2) {
                counts[s.charAt(left) - 'a']--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
