# 190. Reverse Bits (Easy)
LeetCode: https://leetcode.com/problems/reverse-bits/

## Summary
Reverse the bit order of a 32-bit integer and return the resulting value. Process one bit at a time from least significant to most significant.

## Constraints
- Input is treated as a 32-bit integer
- 0 <= n <= 2^31 - 2 (per shown statement variant)

## Examples
- Input: n=43261596 -> Output: 964176192
- Input: n=2147483644 -> Output: 1073741822

## Notes
- Build the answer by left-shifting and appending the current lowest bit of `n`.
- Repeat exactly 32 iterations, then return the built value.
- Time complexity: `O(32)` and space complexity: `O(1)`.
