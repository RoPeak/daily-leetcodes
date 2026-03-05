from typing import List

class Solution:
    def maximizeSquareHoleArea(self, n: int, m: int, hBars: List[int], vBars: List[int]) -> int:
        def max_consecutive(arr: List[int]) -> int:
            if not arr:
                return 0
            arr.sort()
            best = 1
            cur = 1
            for i in range(1, len(arr)):
                if arr[i] == arr[i-1] + 1:
                    cur += 1
                else:
                    if cur > best:
                        best = cur
                    cur = 1
            if cur > best:
                best = cur
            return best

        h = max_consecutive(hBars) + 1
        v = max_consecutive(vBars) + 1
        side = h if h < v else v
        return side * side