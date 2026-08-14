# 3090. Maximum Length Substring With Two Occurrences (Easy)
LeetCode: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/

## Summary
You are given a string and need to find the maximum length of a substring where each character appears at most twice.

## Constraints
- 2 <= s.length <= 100
- s consists only of lowercase English letters.

## Examples
- Input: s = "bcbbbcba" -> Output: 4
- Input: s = "aaaa" -> Output: 2

## Notes
- A sliding window is enough: expand the right end, and when any character would appear a third time, shrink the left end until the invariant is restored.
- Maintain a frequency array for the letters in the current window.
- The longest valid window is tracked as we move through the string.
- Time complexity: O(n). Space complexity: O(1) because the alphabet is fixed to 26 lowercase letters.
