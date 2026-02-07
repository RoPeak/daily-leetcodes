class Solution:
    def minimumDeletions(self, s: str) -> int:
        count_b = 0
        deletions = 0

        for ch in s:
            if ch == "b":
                count_b += 1
            else:
                deletions = min(deletions + 1, count_b)

        return deletions
