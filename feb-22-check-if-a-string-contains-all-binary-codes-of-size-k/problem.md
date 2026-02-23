# 1461. Check If a String Contains All Binary Codes of Size K (Medium)
LeetCode: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

## Summary
Given a binary string `s` and integer `k`, determine whether every possible binary code of length `k` appears as a substring of `s`.

## Constraints
- 1 <= s.length <= 5 * 10^5
- `s[i]` is `'0'` or `'1'`
- 1 <= k <= 20

## Examples
- Input: s="00110110", k=2 -> Output: true
- Input: s="0110", k=1 -> Output: true
- Input: s="0110", k=2 -> Output: false

## Notes
- Track each length-`k` window as an integer bitmask and update it in O(1) while sliding.
- Need to see all `2^k` possible masks; if `2^k > s.length - k + 1`, return false immediately.
- Time complexity: O(n), space complexity: O(2^k).
