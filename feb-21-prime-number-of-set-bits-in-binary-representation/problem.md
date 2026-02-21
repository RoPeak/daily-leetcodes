# 762. Prime Number of Set Bits in Binary Representation (Easy)
LeetCode: https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/

## Summary
Count integers in `[left, right]` whose number of set bits is prime. Since values are at most `10^6`, each popcount is small and can be checked against a fixed prime set.

## Constraints
- 1 <= left <= right <= 10^6
- 0 <= right - left <= 10^4

## Examples
- Input: left=6, right=10 -> Output: 4
- Input: left=10, right=15 -> Output: 5

## Notes
- Iterate from `left` to `right`, compute popcount for each number, and test if it is in `{2, 3, 5, 7, 11, 13, 17, 19}`.
- Max popcount needed is for numbers up to `10^6` (at most 20 bits), so a small constant prime lookup is sufficient.
- Time complexity: O((right - left + 1) * B), where `B` is bit-length (`<= 20`). Space complexity: O(1).
