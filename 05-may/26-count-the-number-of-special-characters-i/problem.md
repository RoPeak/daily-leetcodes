# 3120. Count the Number of Special Characters I (Easy)
LeetCode: https://leetcode.com/problems/count-the-number-of-special-characters-i/

## Summary
Count how many English letters appear in both lowercase and uppercase form in the given string. Each letter contributes at most once to the answer.

## Constraints
- `1 <= word.length <= 50`
- `word` consists only of lowercase and uppercase English letters

## Examples
- Input: `word = "aaAbcBC"` -> Output: `3`
- Input: `word = "abc"` -> Output: `0`
- Input: `word = "abBCab"` -> Output: `1`

## Notes
- Track which lowercase letters appear and which uppercase letters appear.
- A letter is special iff it exists in both sets.
- Since there are only 26 English letters, checking all letters is constant work.
- Time complexity: `O(n)`. Space complexity: `O(1)`.
