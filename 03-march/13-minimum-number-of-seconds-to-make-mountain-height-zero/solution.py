class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: list[int]) -> int:
        def max_units(time_limit: int, worker_time: int) -> int:
            lo = 0
            hi = mountainHeight
            while lo < hi:
                mid = (lo + hi + 1) // 2
                if worker_time * mid * (mid + 1) // 2 <= time_limit:
                    lo = mid
                else:
                    hi = mid - 1
            return lo

        def feasible(time_limit: int) -> bool:
            removed = 0
            for worker_time in workerTimes:
                removed += max_units(time_limit, worker_time)
                if removed >= mountainHeight:
                    return True
            return False

        fastest = min(workerTimes)
        lo = 0
        hi = fastest * mountainHeight * (mountainHeight + 1) // 2

        while lo < hi:
            mid = (lo + hi) // 2
            if feasible(mid):
                hi = mid
            else:
                lo = mid + 1

        return lo
