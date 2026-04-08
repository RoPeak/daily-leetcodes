class Solution:
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:
        MOD = 10 ** 9 + 7
        for l, r, k, v in queries:
            for idx in range(l, r + 1, k):
                nums[idx] = nums[idx] * v % MOD
        return reduce(lambda a, b: a ^ b, nums)
