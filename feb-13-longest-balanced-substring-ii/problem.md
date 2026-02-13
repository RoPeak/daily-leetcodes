# 3714. Longest Balanced Substring II (Medium)
LeetCode: https://leetcode.com/problems/longest-balanced-substring-ii/

## Summary
Find the maximum length substring where all distinct characters appear the same number of times. Here the string contains only `a`, `b`, and `c`, and `s.length` can be up to `10^5`, so a linear solution is required.

## Constraints
- 1 <= s.length <= 10^5
- s contains only the characters 'a', 'b', and 'c'

## Examples
- Input: s="abbac" -> Output: 4
- Input: s="aabcc" -> Output: 3
- Input: s="aba" -> Output: 2

## Notes
- Use prefix counts of `a`, `b`, `c` and hash maps of earliest indices for normalized signatures.
- Track 7 cases: one-character, two-character (third count unchanged), and three-character equal-count signatures.
- Complexity: `O(n)` time and `O(n)` space.
