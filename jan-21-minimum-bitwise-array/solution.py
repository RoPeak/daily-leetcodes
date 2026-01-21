class Solution:
    def minBitwiseArray(self, nums):
        res = []
        for p in nums:
            if p % 2 == 0:
                res.append(-1)
                continue
            temp = p
            cnt = 0
            while temp & 1:
                cnt += 1
                temp >>= 1
            res.append(p - (1 << (cnt - 1)))
        return res
