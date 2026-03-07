class Solution:
    def minFlips(self, s: str) -> int:
        n = len(s)
        diff0 = 0
        diff1 = 0
        ans = n

        for i in range(2 * n):
            ch = s[i % n]
            expected0 = "0" if i % 2 == 0 else "1"
            expected1 = "1" if i % 2 == 0 else "0"

            if ch != expected0:
                diff0 += 1
            if ch != expected1:
                diff1 += 1

            if i >= n:
                left = s[(i - n) % n]
                left_expected0 = "0" if (i - n) % 2 == 0 else "1"
                left_expected1 = "1" if (i - n) % 2 == 0 else "0"
                if left != left_expected0:
                    diff0 -= 1
                if left != left_expected1:
                    diff1 -= 1

            if i >= n - 1:
                ans = min(ans, diff0, diff1)

        return ans
