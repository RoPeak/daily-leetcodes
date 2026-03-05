# 3651. Minimum Cost Path with Teleportations (Hard)
LeetCode: https://leetcode.com/problems/minimum-cost-path-with-teleportations/

## Summary
Move right or down paying the destination value, and optionally teleport up to k times to any cell with a value not greater than the current cell. Find the minimum total cost to reach the bottom-right cell.

## Constraints
- 2 <= m, n <= 80
- 0 <= grid[i][j] <= 1e4
- 0 <= k <= 10

## Examples
- Input: grid = [[1,3,3],[2,5,4],[4,3,5]], k = 2 -> Output: 7
- Input: grid = [[1,2],[2,3],[3,4]], k = 1 -> Output: 9

## Notes
- Use DP layers by teleport count, plus value-based suffix minima to model teleporting into any cell.
