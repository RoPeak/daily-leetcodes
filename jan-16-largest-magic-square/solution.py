from typing import List


class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        row = [[0] * (n + 1) for _ in range(m)]
        col = [[0] * n for _ in range(m + 1)]
        d1 = [[0] * (n + 1) for _ in range(m + 1)]
        d2 = [[0] * (n + 1) for _ in range(m + 1)]

        for i in range(m):
            for j in range(n):
                val = grid[i][j]
                row[i][j + 1] = row[i][j] + val
                col[i + 1][j] = col[i][j] + val
                d1[i + 1][j + 1] = d1[i][j] + val
                d2[i + 1][j] = d2[i][j + 1] + val

        def row_sum(i: int, c: int, k: int) -> int:
            return row[i][c + k] - row[i][c]

        def col_sum(r: int, j: int, k: int) -> int:
            return col[r + k][j] - col[r][j]

        def diag1_sum(r: int, c: int, k: int) -> int:
            return d1[r + k][c + k] - d1[r][c]

        def diag2_sum(r: int, c: int, k: int) -> int:
            return d2[r + k][c] - d2[r][c + k]

        for k in range(min(m, n), 1, -1):
            for r in range(m - k + 1):
                for c in range(n - k + 1):
                    target = row_sum(r, c, k)
                    if diag1_sum(r, c, k) != target or diag2_sum(r, c, k) != target:
                        continue
                    ok = True
                    for i in range(r, r + k):
                        if row_sum(i, c, k) != target:
                            ok = False
                            break
                    if not ok:
                        continue
                    for j in range(c, c + k):
                        if col_sum(r, j, k) != target:
                            ok = False
                            break
                    if ok:
                        return k
        return 1
