from typing import List


class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        counts = [0] * 26
        left = 0
        answer = 0

        for right, ch in enumerate(s):
            idx = ord(ch) - ord("a")
            counts[idx] += 1

            while counts[idx] > 2:
                counts[ord(s[left]) - ord("a")] -= 1
                left += 1

            answer = max(answer, right - left + 1)

        return answer
