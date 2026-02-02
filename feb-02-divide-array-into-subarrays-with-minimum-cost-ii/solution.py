from typing import List
import heapq


class Solution:
    def minimumCost(self, nums: List[int], k: int, dist: int) -> int:
        n = len(nums)
        need = k - 2
        if need == 0:
            return nums[0] + min(nums[1:])

        small = []  # max-heap via negatives
        large = []  # min-heap
        delayed_small = {}
        delayed_large = {}
        size_small = 0
        size_large = 0
        sum_small = 0

        def prune(heap, delayed, sign):
            while heap:
                val = heap[0] * sign
                if delayed.get(val, 0):
                    heapq.heappop(heap)
                    delayed[val] -= 1
                    if delayed[val] == 0:
                        del delayed[val]
                else:
                    break

        def get_max_small():
            prune(small, delayed_small, -1)
            return -small[0] if small else None

        def rebalance():
            nonlocal size_small, size_large, sum_small
            prune(small, delayed_small, -1)
            prune(large, delayed_large, 1)
            while size_small > need:
                val = -heapq.heappop(small)
                sum_small -= val
                size_small -= 1
                heapq.heappush(large, val)
                size_large += 1
                prune(small, delayed_small, -1)
            while size_small < need and large:
                prune(large, delayed_large, 1)
                if not large:
                    break
                val = heapq.heappop(large)
                size_large -= 1
                heapq.heappush(small, -val)
                size_small += 1
                sum_small += val
                prune(large, delayed_large, 1)

        def add(x: int):
            nonlocal size_small, size_large, sum_small
            if size_small < need:
                heapq.heappush(small, -x)
                size_small += 1
                sum_small += x
            else:
                max_small = get_max_small()
                if max_small is not None and x < max_small:
                    heapq.heappush(small, -x)
                    size_small += 1
                    sum_small += x
                else:
                    heapq.heappush(large, x)
                    size_large += 1
            rebalance()

        def remove(x: int):
            nonlocal size_small, size_large, sum_small
            max_small = get_max_small()
            if max_small is not None and x <= max_small:
                delayed_small[x] = delayed_small.get(x, 0) + 1
                size_small -= 1
                sum_small -= x
                prune(small, delayed_small, -1)
            else:
                delayed_large[x] = delayed_large.get(x, 0) + 1
                size_large -= 1
                prune(large, delayed_large, 1)
            rebalance()

        end = min(n - 1, 1 + dist)
        for idx in range(2, end + 1):
            add(nums[idx])

        best = float("inf")
        for i1 in range(1, n):
            start = i1 + 1
            end = min(n - 1, i1 + dist)
            window_len = end - start + 1
            if window_len >= need:
                best = min(best, nums[0] + nums[i1] + sum_small)

            if i1 == n - 1:
                break
            if start <= n - 1:
                remove(nums[start])
            next_end = i1 + dist + 1
            if next_end <= n - 1:
                add(nums[next_end])

        return best
