# 1895. Largest Magic Square (Medium)
LeetCode: https://leetcode.com/problems/largest-magic-square/

## Summary
Find the largest k x k subgrid where all row sums, column sums, and both diagonal sums are equal.

## Constraints
- 1 <= m, n <= 50
- 1 <= grid[i][j] <= 1e6

## Examples
- Input: grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]] -> Output: 3
- Input: grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]] -> Output: 2

## Notes
- Idea: precompute row, column, and diagonal prefix sums, then check squares from largest to smallest.
