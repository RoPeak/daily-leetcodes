# 3546. Equal Sum Grid Partition I (Medium)
LeetCode: https://leetcode.com/problems/equal-sum-grid-partition-i/

## Summary
Determine if a single horizontal or vertical cut can partition the grid into two non-empty sections with equal sums. Return true if such a cut exists.

## Constraints
- 1 <= m, n <= 10^5
- 2 <= m * n <= 10^5
- 1 <= grid[i][j] <= 10^5

## Examples
- Input: grid = [[1,4],[2,3]] -> Output: true (horizontal cut between rows 0 and 1: each section sums to 5)
- Input: grid = [[1,3],[2,4]] -> Output: false (no equal partition)

## Notes
- Check each possible horizontal cut (between rows i and i+1) and vertical cut (between cols j and j+1).
- Horizontal cut at row i: sum(grid[0..i]) == sum(grid[i+1..m-1]).
- Vertical cut at col j: sum(grid[:][0..j]) == sum(grid[:][j+1..n-1]).
- Precompute row sums and column sums for O(1) lookup per cut.
- Time: O(m*n), Space: O(m+n).
