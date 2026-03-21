class Solution:
    def reverseSubmatrix(self, grid: list[list[int]], x: int, y: int, k: int) -> list[list[int]]:
        for row_offset in range(k // 2):
            top = x + row_offset
            bottom = x + k - 1 - row_offset
            for col in range(y, y + k):
                grid[top][col], grid[bottom][col] = grid[bottom][col], grid[top][col]
        return grid
