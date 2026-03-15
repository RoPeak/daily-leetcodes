# 1622. Fancy Sequence (Hard)
LeetCode: https://leetcode.com/problems/fancy-sequence/

## Summary
Implement a sequence supporting append, add-all, multiply-all, and point query operations under modulo `10^9 + 7`.

## Constraints
- 1 <= val, inc, m <= 100
- 0 <= idx <= 10^5
- At most 10^5 calls total are made

## Examples
- Input: `["Fancy","append","addAll","append","multAll","getIndex","addAll","append","multAll","getIndex","getIndex","getIndex"]` -> Output: `[null,null,null,null,null,10,null,null,null,26,34,20]`

## Notes
- Treat `addAll` and `multAll` as affine range updates on the active prefix.
- A segment tree with lazy `(mul, add)` tags supports prefix updates and point queries in `O(log n)`.
- This avoids modular inverse edge cases such as `multAll(0)`.
