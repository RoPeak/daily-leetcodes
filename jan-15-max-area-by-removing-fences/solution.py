from typing import List

class Solution:
    def maximizeSquareArea(self, m: int, n: int, hFences: List[int], vFences: List[int]) -> int:
        MOD = 10**9 + 7

        def diff_set(arr: List[int], limit: int) -> set[int]:
            all_vals = arr[:] + [1, limit]
            all_vals.sort()
            res = set()
            for i in range(len(all_vals)):
                for j in range(i + 1, len(all_vals)):
                    res.add(all_vals[j] - all_vals[i])
            return res

        hset = diff_set(hFences, m)
        vset = diff_set(vFences, n)

        best = -1
        for d in hset:
            if d in vset and d > best:
                best = d

        if best == -1:
            return -1
        return (best * best) % MOD
