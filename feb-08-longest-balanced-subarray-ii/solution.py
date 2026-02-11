from typing import List


class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        n = len(nums)
        seg_size = 4 * n
        mn = [0] * seg_size
        mx = [0] * seg_size
        lazy = [0] * seg_size

        def apply(i: int, delta: int) -> None:
            mn[i] += delta
            mx[i] += delta
            lazy[i] += delta

        def push(i: int) -> None:
            delta = lazy[i]
            if delta == 0:
                return
            left = i << 1
            right = left | 1
            mn[left] += delta
            mx[left] += delta
            lazy[left] += delta
            mn[right] += delta
            mx[right] += delta
            lazy[right] += delta
            lazy[i] = 0

        def pull(i: int) -> None:
            left = i << 1
            right = left | 1
            mn[i] = mn[left] if mn[left] < mn[right] else mn[right]
            mx[i] = mx[left] if mx[left] > mx[right] else mx[right]

        def range_add(i: int, l: int, r: int, ql: int, qr: int, delta: int) -> None:
            if ql <= l and r <= qr:
                apply(i, delta)
                return
            push(i)
            m = (l + r) >> 1
            if ql <= m:
                range_add(i << 1, l, m, ql, qr, delta)
            if qr > m:
                range_add((i << 1) | 1, m + 1, r, ql, qr, delta)
            pull(i)

        def first_zero(i: int, l: int, r: int, ql: int, qr: int) -> int:
            if ql <= l and r <= qr:
                if mn[i] > 0 or mx[i] < 0:
                    return -1
                if l == r:
                    return l
            elif r < ql or l > qr:
                return -1

            if l == r:
                return -1

            push(i)
            m = (l + r) >> 1
            if ql <= m:
                left_res = first_zero(i << 1, l, m, ql, qr)
                if left_res != -1:
                    return left_res
            if qr > m:
                return first_zero((i << 1) | 1, m + 1, r, ql, qr)
            return -1

        last_pos = [-1] * 100001
        ans = 0

        for r, x in enumerate(nums):
            left = last_pos[x] + 1
            delta = 1 if (x & 1) == 0 else -1
            range_add(1, 0, n - 1, left, r, delta)
            last_pos[x] = r

            l = first_zero(1, 0, n - 1, 0, r)
            if l != -1 and r - l + 1 > ans:
                ans = r - l + 1

        return ans
