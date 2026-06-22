# 1189. Maximum Number of Balloons (Easy)
LeetCode: https://leetcode.com/problems/maximum-number-of-balloons/

## Summary
Count how many times the letters in `text` can form the word `balloon`, using each character at most once.

## Constraints
- `1 <= text.length <= 10^4`
- `text` consists of lowercase English letters only.

## Examples
- Input: `text = "nlaebolko"` -> Output: `1`
- Input: `text = "loonbalxballpoon"` -> Output: `2`
- Input: `text = "leetcode"` -> Output: `0`

## Notes
- Count the five distinct letters needed for `balloon`.
- Each copy needs one `b`, one `a`, one `n`, two `l`s, and two `o`s.
- The least available required letter determines the answer.
- Time complexity: `O(n)`. Space complexity: `O(1)`.
