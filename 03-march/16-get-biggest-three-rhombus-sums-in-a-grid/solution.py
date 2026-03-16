class Solution:
    def getBiggestThree(self, grid: list[list[int]]) -> list[int]:
        rows = len(grid)
        cols = len(grid[0])
        seen = set()

        for r in range(rows):
            for c in range(cols):
                seen.add(grid[r][c])
                max_size = min((cols - 1 - c), c, (rows - 1 - r) // 2)
                for size in range(1, max_size + 1):
                    total = 0

                    x, y = r, c
                    for _ in range(size):
                        total += grid[x][y]
                        x += 1
                        y += 1

                    for _ in range(size):
                        total += grid[x][y]
                        x += 1
                        y -= 1

                    for _ in range(size):
                        total += grid[x][y]
                        x -= 1
                        y -= 1

                    for _ in range(size):
                        total += grid[x][y]
                        x -= 1
                        y += 1

                    seen.add(total)

        return sorted(seen, reverse=True)[:3]
