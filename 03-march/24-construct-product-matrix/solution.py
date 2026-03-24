class Solution:
    def constructProductMatrix(self, grid: list[list[int]]) -> list[list[int]]:
        MOD = 12345
        n, m = len(grid), len(grid[0])
        N = n * m
        flat = [grid[i][j] for i in range(n) for j in range(m)]

        result = [1] * N

        prefix = 1
        for k in range(N):
            result[k] = prefix
            prefix = prefix * flat[k] % MOD

        suffix = 1
        for k in range(N - 1, -1, -1):
            result[k] = result[k] * suffix % MOD
            suffix = suffix * flat[k] % MOD

        return [result[i * m:(i + 1) * m] for i in range(n)]
