# 3721. Longest Balanced Subarray II (Hard)
LeetCode: https://leetcode.com/problems/longest-balanced-subarray-ii/

## Summary
Find the maximum length subarray where the number of distinct even values equals the number of distinct odd values.

## Constraints
- 1 <= nums.length <= 1e5
- 1 <= nums[i] <= 1e5

## Examples
- Input: nums = [2,5,4,3] -> Output: 4
- Input: nums = [3,2,2,5,4] -> Output: 5
- Input: nums = [1,2,3,2] -> Output: 3

## Notes
- For each right endpoint `r`, track `diff(l, r) = distinctEven(l, r) - distinctOdd(l, r)` for all starts `l`.
- When extending to `r`, only `l` in `[lastPos[nums[r]] + 1, r]` change (range add by `+1` if even else `-1`).
- Need earliest `l` with `diff(l, r) = 0`, solved with sqrt decomposition (range add + first zero query).
