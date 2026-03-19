# 3212. Count Submatrices With Equal Frequency of X and Y (Medium)
LeetCode: https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/

## Summary
Count submatrices that include `grid[0][0]`, contain an equal number of `'X'` and `'Y'`, and contain at least one `'X'`.

## Constraints
- 1 <= grid.length, grid[i].length <= 1000
- `grid[i][j]` is `'X'`, `'Y'`, or `'.'`

## Examples
- Input: grid=[["X","Y","."],["Y",".","."]] -> Output: 3
- Input: grid=[["X","X"],["X","Y"]] -> Output: 0
- Input: grid=[[".","."],[".","."]] -> Output: 0

## Notes
- Because every valid submatrix must contain `grid[0][0]`, every candidate is a prefix submatrix `(0,0) -> (r,c)`.
- Track 2D prefix counts of `'X'` and `'Y'`.
- A prefix contributes if `countX == countY` and `countX > 0`.
- Time complexity: O(m * n), space complexity: O(n).
