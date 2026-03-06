# 1784. Check if Binary String Has at Most One Segment of Ones (Easy)
LeetCode: https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

## Summary
Given a binary string `s` without leading zeros, determine whether all `'1'` characters form at most one contiguous block.

## Constraints
- 1 <= s.length <= 100
- `s[i]` is either `'0'` or `'1'`
- `s[0]` is `'1'`

## Examples
- Input: s="1001" -> Output: false
- Input: s="110" -> Output: true

## Notes
- The string has more than one segment of ones iff pattern `"01"` appears.
- Return whether `"01"` is absent.
- Time complexity: O(n), space complexity: O(1).
