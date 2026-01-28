from typing import List


class Solution:
    def minCost(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        max_val = max(max(row) for row in grid)
        INF = 10**18

        dist = [[INF] * n for _ in range(m)]
        dist[0][0] = 0
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    continue
                best = INF
                if i > 0:
                    best = min(best, dist[i - 1][j] + grid[i][j])
                if j > 0:
                    best = min(best, dist[i][j - 1] + grid[i][j])
                dist[i][j] = best

        for _ in range(k):
            min_by_val = [INF] * (max_val + 1)
            for i in range(m):
                for j in range(n):
                    v = grid[i][j]
                    if dist[i][j] < min_by_val[v]:
                        min_by_val[v] = dist[i][j]

            suffix = [INF] * (max_val + 2)
            for v in range(max_val, -1, -1):
                suffix[v] = min(min_by_val[v], suffix[v + 1])

            new_dist = [[INF] * n for _ in range(m)]
            for i in range(m):
                for j in range(n):
                    new_dist[i][j] = min(dist[i][j], suffix[grid[i][j]])

            for i in range(m):
                for j in range(n):
                    if i == 0 and j == 0:
                        new_dist[i][j] = min(new_dist[i][j], 0)
                        continue
                    best = new_dist[i][j]
                    if i > 0:
                        best = min(best, new_dist[i - 1][j] + grid[i][j])
                    if j > 0:
                        best = min(best, new_dist[i][j - 1] + grid[i][j])
                    new_dist[i][j] = best

            dist = new_dist

        return dist[m - 1][n - 1]
