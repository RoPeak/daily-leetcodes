# 3567. Minimum Absolute Difference in Sliding Submatrix (Medium)
LeetCode: https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/

## Summary
For each `k × k` submatrix, compute the smallest absolute difference between any two distinct elements or 0 when all values match.

## Constraints
- 1 <= m, n <= 30
- -10^5 <= grid[i][j] <= 10^5
- 1 <= k <= min(m, n)

## Examples
- Input: `grid = [[1,8],[3,-2]]`, `k = 2` -> `[[2]]`
- Input: `grid = [[3,-1]]`, `k = 1` -> `[[0,0]]`
- Input: `grid = [[1,-2,3],[2,3,5]]`, `k = 2` -> `[[1,2]]`

## Notes
- Constraints allow iterating each window and sorting `k²` values (≤900).
- Track distinct values only to detect zero diffs quickly.
- Time complexity: `O(m * n * k² log k²)`, space `O(k²)`.
