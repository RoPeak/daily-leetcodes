class Solution:
    def longestBalanced(self, s: str) -> int:
        n = len(s)
        best = 0

        for left in range(n):
            counts = [0] * 26
            freq_count = {}

            for right in range(left, n):
                idx = ord(s[right]) - ord("a")
                old_freq = counts[idx]
                if old_freq > 0:
                    freq_count[old_freq] -= 1
                    if freq_count[old_freq] == 0:
                        del freq_count[old_freq]

                counts[idx] += 1
                new_freq = counts[idx]
                freq_count[new_freq] = freq_count.get(new_freq, 0) + 1

                if len(freq_count) == 1:
                    best = max(best, right - left + 1)

        return best
