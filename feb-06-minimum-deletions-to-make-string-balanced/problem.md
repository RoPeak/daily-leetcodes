# 1653. Minimum Deletions to Make String Balanced (Medium)
LeetCode: https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/

## Summary
Delete the fewest characters so no `'b'` appears before an `'a'`.

## Constraints
- 1 <= s.length <= 1e5
- `s[i]` is `'a'` or `'b'`

## Examples
- Input: s = "aababbab" -> Output: 2
- Input: s = "bbaaaaabb" -> Output: 2

## Notes
- Scan left to right:
- `countB` = number of kept `'b'` so far.
- `deletions` = minimum deletions needed up to current index.
- For `'a'`, either delete this `'a'` or delete all previous `'b'`.
