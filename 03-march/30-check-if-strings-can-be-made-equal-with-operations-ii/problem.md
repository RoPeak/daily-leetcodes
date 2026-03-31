# 2840. Check if Strings Can be Made Equal With Operations II (Medium)

LeetCode: https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/

## Summary
Given two lowercase strings of equal length, you may swap any two characters whose indices differ by an even number. Determine whether repeated swaps can transform `s1` into `s2`.

## Constraints
- `n == s1.length == s2.length`
- `1 <= n <= 10^5`
- `s1` and `s2` consist only of lowercase English letters

## Examples
- `s1 = "abcdba"`, `s2 = "cabdab"` → `true`
- `s1 = "abe"`, `s2 = "bea"` → `false`

## Notes
- Swaps preserve index parity, so characters at even positions can only move among even positions, and odd positions among odd positions.
- The strings are reachable iff the multiset of even-index characters matches and the multiset of odd-index characters matches.
- Count each letter separately for even and odd indices, then compare the two frequency tables.
- Time: O(n), Space: O(1) because the alphabet size is fixed at 26.
