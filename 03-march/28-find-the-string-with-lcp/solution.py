class Solution:
    def findTheString(self, lcp: List[List[int]]) -> str:
        n = len(lcp)
        word = [''] * n

        char_idx = 0
        for i in range(n):
            if word[i]:
                continue
            if char_idx >= 26:
                return ""
            word[i] = chr(ord('a') + char_idx)
            char_idx += 1
            for j in range(i + 1, n):
                if lcp[i][j] > 0:
                    if word[j] and word[j] != word[i]:
                        return ""
                    word[j] = word[i]

        dp = [[0] * n for _ in range(n)]
        for i in range(n - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if word[i] == word[j]:
                    dp[i][j] = (dp[i + 1][j + 1] if i + 1 < n and j + 1 < n else 0) + 1
                if dp[i][j] != lcp[i][j]:
                    return ""

        return ''.join(word)
