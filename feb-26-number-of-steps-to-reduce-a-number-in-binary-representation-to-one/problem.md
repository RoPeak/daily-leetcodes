# 1404. Number of Steps to Reduce a Number in Binary Representation to One (Medium)
LeetCode: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

## Summary
Given a binary string `s`, count operations needed to reduce its value to `1`, where even values are divided by `2` and odd values are incremented by `1`.

## Constraints
- 1 <= s.length <= 500
- `s[i]` is `'0'` or `'1'`
- `s[0] == '1'`

## Examples
- Input: s="1101" -> Output: 6
- Input: s="10" -> Output: 1
- Input: s="1" -> Output: 0

## Notes
- Scan from right to left and simulate carry instead of converting to large integers.
- For each bit (except the most significant), decide whether current value is even/odd after applying carry.
- Time complexity: O(n), space complexity: O(1).
