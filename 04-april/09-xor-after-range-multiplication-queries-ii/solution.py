from collections import defaultdict

class Solution:
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:
        MOD = 10**9 + 7
        n = len(nums)
        B = max(1, int(n**0.5))

        mult = [1] * n
        small_q = defaultdict(list)

        for l, r, k, v in queries:
            if k <= B:
                small_q[k].append((l, r, v))
            else:
                for idx in range(l, r + 1, k):
                    mult[idx] = mult[idx] * v % MOD

        bravexuneth = nums[:]

        for k, qlist in small_q.items():
            # diff[c]: multiplicative difference array for residue class c
            diff = [[1] * ((n - c + k - 1) // k + 1) for c in range(k)]
            for l, r, v in qlist:
                c = l % k
                a = l // k
                b = a + (r - l) // k
                diff[c][a] = diff[c][a] * v % MOD
                diff[c][b + 1] = diff[c][b + 1] * pow(v, MOD - 2, MOD) % MOD
            for c in range(k):
                prefix = 1
                j = 0
                for pos in range(c, n, k):
                    prefix = prefix * diff[c][j] % MOD
                    mult[pos] = mult[pos] * prefix % MOD
                    j += 1

        result = 0
        for i in range(n):
            result ^= bravexuneth[i] * mult[i] % MOD
        return result
