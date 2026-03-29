# 2839. Check if Strings Can be Made Equal With Operations I (Easy)

LeetCode: https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/

## Summary
Given two length-4 strings, you can swap characters at indices i and j where j - i = 2 any number of times. Determine if s1 can be made equal to s2.

## Constraints
- `s1.length == s2.length == 4`
- Both strings consist of lowercase English letters

## Examples
- `s1 = "abcd"`, `s2 = "cdab"` → `true` (swap (0,2) then (1,3))
- `s1 = "abcd"`, `s2 = "dacb"` → `false`

## Notes
- Only swaps (0,2) and (1,3) are valid on length-4 strings.
- Even indices {0,2} and odd indices {1,3} each form independent swap groups.
- s1 == s2 iff sorted({s1[0],s1[2]}) == sorted({s2[0],s2[2]}) and sorted({s1[1],s1[3]}) == sorted({s2[1],s2[3]}).
- Time: O(1), Space: O(1)
