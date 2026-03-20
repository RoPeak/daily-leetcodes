class Solution:
    def minAbsDiff(self, grid: list[list[int]], k: int) -> list[list[int]]:
        rows = len(grid)
        cols = len(grid[0])
        ans = []
        for i in range(rows - k + 1):
            row_ans = []
            for j in range(cols - k + 1):
                values = []
                seen = set()
                for x in range(i, i + k):
                    for y in range(j, j + k):
                        val = grid[x][y]
                        if val not in seen:
                            values.append(val)
                            seen.add(val)
                if len(values) <= 1:
                    row_ans.append(0)
                else:
                    values.sort()
                    diff = min(values[p + 1] - values[p] for p in range(len(values) - 1))
                    row_ans.append(diff)
            ans.append(row_ans)
        return ans
