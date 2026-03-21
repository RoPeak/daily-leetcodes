# 3643. Flip Square Submatrix Vertically (Easy)
LeetCode: https://leetcode.com/problems/flip-square-submatrix-vertically/

## Summary
Rotate a `k × k` square submatrix by reversing its rows in place.

## Constraints
- 1 <= m, n <= 50
- 1 <= grid[i][j] <= 100
- 0 <= x < m
- 0 <= y < n
- 1 <= k <= min(m - x, n - y)

## Examples
- Input: `grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]`, `x = 1`, `y = 0`, `k = 3` -> output `[[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]`
- Input: `grid = [[3,4,2,3],[2,3,4,2]]`, `x = 0`, `y = 2`, `k = 2` -> output `[[3,4,4,2],[2,3,2,3]]`

## Notes
- Copy each row of the submatrix into a buffer and write them back in reversed order.
