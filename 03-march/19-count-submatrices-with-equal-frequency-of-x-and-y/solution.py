class Solution:
    def numberOfSubmatrices(self, grid: list[list[str]]) -> int:
        cols = len(grid[0])
        x_col = [0] * cols
        y_col = [0] * cols
        ans = 0

        for row in grid:
            x_prefix = 0
            y_prefix = 0
            for c, ch in enumerate(row):
                if ch == "X":
                    x_col[c] += 1
                elif ch == "Y":
                    y_col[c] += 1

                x_prefix += x_col[c]
                y_prefix += y_col[c]

                if x_prefix > 0 and x_prefix == y_prefix:
                    ans += 1

        return ans
