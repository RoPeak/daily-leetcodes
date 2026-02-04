from typing import List


class Solution:
    def maxSumTrionic(self, nums: List[int]) -> int:
        n = len(nums)
        NEG = -10**30
        inc = [NEG] * n
        dec = [NEG] * n
        tri = [NEG] * n

        for i in range(1, n):
            if nums[i - 1] < nums[i]:
                inc[i] = max(inc[i - 1] + nums[i], nums[i - 1] + nums[i])

            if nums[i - 1] > nums[i]:
                if inc[i - 1] > NEG:
                    dec[i] = max(dec[i], inc[i - 1] + nums[i])
                if dec[i - 1] > NEG:
                    dec[i] = max(dec[i], dec[i - 1] + nums[i])

            if nums[i - 1] < nums[i]:
                if dec[i - 1] > NEG:
                    tri[i] = max(tri[i], dec[i - 1] + nums[i])
                if tri[i - 1] > NEG:
                    tri[i] = max(tri[i], tri[i - 1] + nums[i])

        return max(tri)
