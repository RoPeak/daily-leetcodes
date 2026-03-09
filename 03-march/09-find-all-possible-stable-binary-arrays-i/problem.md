# 3129. Find All Possible Stable Binary Arrays I (Medium)
LeetCode: https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/

## Summary
Count binary arrays with exactly `zero` zeros and `one` ones such that no subarray longer than `limit` is all the same value.

## Constraints
- 1 <= zero, one, limit <= 200

## Examples
- Input: zero=1, one=1, limit=2 -> Output: 2
- Input: zero=1, one=2, limit=1 -> Output: 1
- Input: zero=3, one=3, limit=2 -> Output: 14

## Notes
- Let `dp0[i][j]` be ways using `i` zeros and `j` ones ending in `0`, and `dp1[i][j]` similarly ending in `1`.
- Use recurrence with subtraction of overlong runs to avoid an extra `limit` loop.
- Time complexity: O(zero * one), space complexity: O(zero * one).
