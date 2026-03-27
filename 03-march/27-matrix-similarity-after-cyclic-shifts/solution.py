class Solution:
    def areSimilar(self, mat: List[List[int]], k: int) -> bool:
        n = len(mat[0])
        for i, row in enumerate(mat):
            shift = k % n
            if shift == 0:
                continue
            if i % 2 == 0:
                shifted = row[shift:] + row[:shift]
            else:
                shifted = row[n - shift:] + row[:n - shift]
            if shifted != row:
                return False
        return True
