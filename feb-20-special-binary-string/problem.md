# 761. Special Binary String (Hard)
LeetCode: https://leetcode.com/problems/special-binary-string/

## Summary
Given a special binary string, repeatedly swap adjacent special substrings to maximize lexicographic order. Return the largest possible string after any number of such swaps.

## Constraints
- 1 <= s.length <= 50
- `s[i]` is `'0'` or `'1'`
- `s` is guaranteed to be a special binary string

## Examples
- Input: s="11011000" -> Output: "11100100"
- Input: s="10" -> Output: "10"

## Notes
- Decompose `s` into top-level special blocks using a balance counter (`+1` for `'1'`, `-1` for `'0'`).
- For each block, recursively maximize its inner substring and wrap it back as `"1" + inner + "0"`.
- Sort all top-level blocks in descending lexicographic order, then concatenate.
- Time complexity: O(n^2 log n) in this implementation due to sorting and string construction. Space complexity: O(n) recursion + intermediate strings.
