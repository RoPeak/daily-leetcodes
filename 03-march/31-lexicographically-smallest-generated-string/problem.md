# 3474. Lexicographically Smallest Generated String (Hard)

LeetCode: https://leetcode.com/problems/lexicographically-smallest-generated-string/

## Summary
Given str1 (of 'T'/'F' chars) and str2, build a word of length n+m-1 such that each 'T' at index i means word[i..i+m-1] == str2, and each 'F' means it doesn't. Return the lexicographically smallest valid word, or "" if impossible.

## Constraints
- 1 <= n == str1.length <= 10^4
- 1 <= m == str2.length <= 500
- str1 consists of 'T' or 'F'
- str2 consists of lowercase English letters

## Examples
- str1="TFTF", str2="ab" → "ababa"
- str1="TFTF", str2="abc" → ""
- str1="F", str2="d" → "a"

## Notes
- Stamp str2 at all 'T' positions; detect conflicts between overlapping stamps.
- For 'F' positions: if window matches str2, increment rightmost unlocked char to 'b'.
- Use KMP failure function to check each 'F' window in O(m) with O(n*m) overall.
- Complexity: O(n*m) time, O(n+m) space.
