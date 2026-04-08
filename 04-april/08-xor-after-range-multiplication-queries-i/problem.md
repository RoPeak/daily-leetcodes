# 3653. XOR After Range Multiplication Queries I (Medium)

LeetCode: https://leetcode.com/problems/xor-after-range-multiplication-queries-i/

## Summary

For each query `[l, r, k, v]`, multiply `nums[idx]` by `v` (mod 10^9+7) for every index `idx` from `l` to `r` stepping by `k`. Return the XOR of all elements after all queries.

## Constraints

- `1 <= n <= 10^3`
- `1 <= nums[i] <= 10^9`
- `1 <= q <= 10^3`
- `0 <= l <= r < n`, `1 <= k <= n`, `1 <= v <= 10^5`

## Examples

- Input: `nums = [1,1,1], queries = [[0,2,1,4]]` → Output: `4`
- Input: `nums = [2,3,1,5,4], queries = [[1,4,2,3],[0,2,1,2]]` → Output: `31`

## Notes

- Pure simulation: n, q ≤ 10^3 so O(n·q) is fine.
- MOD = 10^9 + 7 applied after each multiply.
- XOR all elements after all queries complete.
- Time: O(n·q), Space: O(1) extra.
