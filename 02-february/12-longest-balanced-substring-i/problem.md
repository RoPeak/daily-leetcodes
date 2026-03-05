# 3713. Longest Balanced Substring I (Medium)
LeetCode: https://leetcode.com/problems/longest-balanced-substring-i/

## Summary
Return the maximum length of a substring where every distinct character appears the same number of times. A valid substring can contain any number of distinct lowercase letters as long as their frequencies are equal.

## Constraints
- 1 <= s.length <= 1000
- s consists of lowercase English letters

## Examples
- Input: s="abbac" -> Output: 4
- Input: s="zzabccy" -> Output: 4
- Input: s="aba" -> Output: 2

## Notes
- Use a start index `left` and expand `right` to evaluate all substrings in `O(n^2)`.
- Maintain per-character counts and a map `frequency -> number of characters currently at that frequency`.
- A substring is balanced exactly when there is only one active non-zero frequency.
