class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        counts = [0] * 26
        for char in text:
            counts[ord(char) - ord("a")] += 1

        return min(
            counts[ord("b") - ord("a")],
            counts[ord("a") - ord("a")],
            counts[ord("l") - ord("a")] // 2,
            counts[ord("o") - ord("a")] // 2,
            counts[ord("n") - ord("a")],
        )
