# 1980. Find Unique Binary String (Medium)
LeetCode: https://leetcode.com/problems/find-unique-binary-string/

## Summary
Given `n` unique binary strings of length `n`, return any binary string of length `n` that is not in the list.

## Constraints
- n == nums.length
- 1 <= n <= 16
- nums[i].length == n
- `nums[i]` contains only `'0'` or `'1'`
- All strings in `nums` are unique

## Examples
- Input: nums=["01","10"] -> Output: "11"
- Input: nums=["00","01"] -> Output: "11"
- Input: nums=["111","011","001"] -> Output: "101"

## Notes
- Use diagonal construction: for index `i`, choose the opposite bit of `nums[i][i]`.
- The result differs from each `nums[i]` at position `i`, so it cannot equal any existing string.
- Time complexity: O(n), space complexity: O(n).
