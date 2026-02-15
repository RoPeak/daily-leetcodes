# 67. Add Binary (Easy)
LeetCode: https://leetcode.com/problems/add-binary/

## Summary
Add two binary strings and return the sum as a binary string. Process from right to left with a carry, exactly like manual addition.

## Constraints
- 1 <= a.length, b.length <= 10^4
- `a` and `b` contain only `'0'` and `'1'`, with no leading zeros except `"0"`

## Examples
- Input: a="11", b="1" -> Output: "100"
- Input: a="1010", b="1011" -> Output: "10101"

## Notes
- Use two pointers from the end of each string and keep a `carry`.
- Append each bit of `sum % 2`, then reverse at the end.
- Time complexity: `O(max(len(a), len(b)))`. Space complexity: `O(max(len(a), len(b)))`.
