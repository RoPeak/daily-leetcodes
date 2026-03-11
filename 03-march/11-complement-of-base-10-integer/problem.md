# 1009. Complement of Base 10 Integer (Easy)
LeetCode: https://leetcode.com/problems/complement-of-base-10-integer/

## Summary
Given a non-negative integer `n`, flip every bit in its binary representation and return the resulting value.

## Constraints
- 0 <= n < 10^9

## Examples
- Input: n=5 -> Output: 2
- Input: n=7 -> Output: 0
- Input: n=10 -> Output: 5

## Notes
- Build a mask of all `1` bits with the same length as `n` in binary.
- The complement is `(mask ^ n)`.
- Special case: `n = 0` returns `1`.
