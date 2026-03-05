from typing import List


class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        m = len(mat)
        n = len(mat[0])

        ps = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            row = mat[i - 1]
            for j in range(1, n + 1):
                ps[i][j] = row[j - 1] + ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1]

        def square_sum(r: int, c: int, k: int) -> int:
            r2 = r + k
            c2 = c + k
            return ps[r2][c2] - ps[r][c2] - ps[r2][c] + ps[r][c]

        lo, hi = 0, min(m, n)
        while lo < hi:
            mid = (lo + hi + 1) // 2
            ok = False
            for i in range(0, m - mid + 1):
                if ok:
                    break
                for j in range(0, n - mid + 1):
                    if square_sum(i, j, mid) <= threshold:
                        ok = True
                        break
            if ok:
                lo = mid
            else:
                hi = mid - 1
        return lo
