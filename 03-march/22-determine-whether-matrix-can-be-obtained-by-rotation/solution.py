class Solution:
    def findRotation(self, mat: list[list[int]], target: list[list[int]]) -> bool:
        def rotate(matrix: list[list[int]]) -> list[list[int]]:
            n = len(matrix)
            return [[matrix[n - 1 - j][i] for j in range(n)] for i in range(n)]

        for _ in range(4):
            if mat == target:
                return True
            mat = rotate(mat)
        return False
