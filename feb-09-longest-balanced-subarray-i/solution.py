class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        n = len(nums)
        best = 0

        for left in range(n):
            even_seen = set()
            odd_seen = set()

            for right in range(left, n):
                value = nums[right]
                if value % 2 == 0:
                    even_seen.add(value)
                else:
                    odd_seen.add(value)

                if len(even_seen) == len(odd_seen):
                    best = max(best, right - left + 1)

        return best
