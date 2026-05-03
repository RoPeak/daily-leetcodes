# 796. Rotate String (Easy)
LeetCode: https://leetcode.com/problems/rotate-string/

## Summary
Determine whether `goal` can be formed by repeatedly moving the first character of `s` to the end. Any valid rotation of `s` must appear inside `s + s`.

## Constraints
- 1 <= s.length, goal.length <= 100
- `s` and `goal` contain only lowercase English letters

## Examples
- Input: s="abcde", goal="cdeab" -> Output: true
- Input: s="abcde", goal="abced" -> Output: false

## Notes
- First require equal lengths; otherwise no rotation can match.
- Check whether `goal` is a substring of `s + s`, which contains every possible rotation.
- Time complexity: `O(n)`. Space complexity: `O(n)`.
