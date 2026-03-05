import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int best = 0;

        for (int left = 0; left < n; left++) {
            int[] counts = new int[26];
            Map<Integer, Integer> freqCount = new HashMap<>();

            for (int right = left; right < n; right++) {
                int idx = s.charAt(right) - 'a';
                int oldFreq = counts[idx];
                if (oldFreq > 0) {
                    int oldCount = freqCount.get(oldFreq) - 1;
                    if (oldCount == 0) {
                        freqCount.remove(oldFreq);
                    } else {
                        freqCount.put(oldFreq, oldCount);
                    }
                }

                counts[idx]++;
                int newFreq = counts[idx];
                freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);

                if (freqCount.size() == 1) {
                    best = Math.max(best, right - left + 1);
                }
            }
        }

        return best;
    }
}
