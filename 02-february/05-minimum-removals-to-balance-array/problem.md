# 3634. Minimum Removals to Balance Array (Medium)
LeetCode: https://leetcode.com/problems/minimum-removals-to-balance-array/

## Summary
Remove the fewest elements so the remaining array has max <= min * k.

## Constraints
- 1 <= nums.length <= 1e5
- 1 <= nums[i] <= 1e9
- 1 <= k <= 1e5

## Examples
- Input: nums=[2,1,5], k=2 -> Output: 1
- Input: nums=[1,6,2,9], k=3 -> Output: 2
- Input: nums=[4,6], k=2 -> Output: 0

## Notes
- Sort and use a sliding window to find the largest valid subarray.
