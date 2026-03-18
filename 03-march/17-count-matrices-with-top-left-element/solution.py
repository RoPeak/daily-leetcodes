from typing import List

class Solution:
    def countSubmatrices(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        col = [0] * n
        ans = 0

        for i in range(m):
            prefix_sum = 0
            for j in range(n):
                col[j] += grid[i][j]
                prefix_sum += col[j]   # sum of submatrix (0,0) to (i,j)
                if prefix_sum <= k:
                    ans += 1

        return ans
      