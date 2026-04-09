# 3655. XOR After Range Multiplication Queries II (Hard)

LeetCode: https://leetcode.com/problems/xor-after-range-multiplication-queries-ii/

## Summary

Same as part I but n, q ≤ 10^5 — naive O(n·q) times out. For each query [l,r,k,v], multiply nums[idx] by v (mod 10^9+7) at every idx from l to r stepping k. Return XOR of all elements after all queries.

## Constraints

- `1 <= n <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= q <= 10^5`
- `0 <= l <= r < n`, `1 <= k <= n`, `1 <= v <= 10^5`

## Examples

- Input: `nums = [1,1,1], queries = [[0,2,1,4]]` → Output: `4`
- Input: `nums = [2,3,1,5,4], queries = [[1,4,2,3],[0,2,1,2]]` → Output: `31`

## Notes

**Sqrt decomposition** with B = √n:
- **Large k (k > B):** simulate directly — each query touches < B positions. Total: O(q·√n).
- **Small k (k ≤ B):** multiplicative difference arrays per residue class.
  - For each k, residue c (0..k-1): diff[c][a] *= v, diff[c][b+1] *= modinv(v), where a=l//k, b=a+(r-l)//k.
  - Prefix-product sweep writes accumulated multiplier into global mult[].
  - Total: O(B·n) = O(n·√n).
- Since mod-multiplication is commutative, query order doesn't affect the accumulated product at each index.
- Time: O(n·√n), Space: O(n).
