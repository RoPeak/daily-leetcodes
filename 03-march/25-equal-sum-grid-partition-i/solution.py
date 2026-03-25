class Solution:
    def canPartitionGrid(self, grid: list[list[int]]) -> bool:
        m, n = len(grid), len(grid[0])
        total = sum(sum(row) for row in grid)

        if total % 2 != 0:
            return False

        half = total // 2

        row_sum = 0
        for i in range(m - 1):
            row_sum += sum(grid[i])
            if row_sum == half:
                return True

        col_sum = 0
        for j in range(n - 1):
            for i in range(m):
                col_sum += grid[i][j]
            if col_sum == half:
                return True

        return False
