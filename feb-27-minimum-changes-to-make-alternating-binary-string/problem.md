# 1758. Minimum Changes To Make Alternating Binary String (Easy)
LeetCode: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

## Summary
Given a binary string `s`, return the minimum number of character flips needed so that no two adjacent characters are the same.

## Constraints
- 1 <= s.length <= 10^4
- `s[i]` is either `'0'` or `'1'`

## Examples
- Input: s="0100" -> Output: 1
- Input: s="10" -> Output: 0
- Input: s="1111" -> Output: 2

## Notes
- Only two valid alternating targets exist: starting with `'0'` (`0101...`) or starting with `'1'` (`1010...`).
- Count mismatches for one pattern; the other is `n - mismatches`.
- Time complexity: O(n), space complexity: O(1).
