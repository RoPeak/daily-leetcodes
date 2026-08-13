# 2213. Longest Substring of One Repeating Character (Hard)
LeetCode: https://leetcode.com/problems/longest-substring-of-one-repeating-character/

## Summary
You are given a string and a sequence of point updates. After each update, return the length of the longest substring containing only one repeating character.

## Constraints
- 1 <= s.length <= 10^5
- k == queryCharacters.length == queryIndices.length
- 1 <= k <= 10^5
- s and queryCharacters consist of lowercase English letters.
- 0 <= queryIndices[i] < s.length

## Examples
- Input: s = "babacc", queryCharacters = "bcb", queryIndices = [1,3,3] -> Output: [3,3,4]
- Input: s = "abyzz", queryCharacters = "aa", queryIndices = [2,1] -> Output: [2,3]

## Notes
- A segment tree can maintain, for every interval, the longest prefix, longest suffix, and global best run of a single character.
- When merging two child segments, the boundary is only valid if both children are uniform and use the same character.
- Each query updates one character and recomputes the affected ancestors in O(log n).
- Time complexity: O((n + k) log n). Space complexity: O(n).
