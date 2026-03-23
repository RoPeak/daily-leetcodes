# 1594. Maximum Non Negative Product in a Matrix (Medium)
LeetCode: https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/

## Summary
Find the path from top-left to bottom-right (moving only right or down) that yields the maximum non-negative product. Return that product mod 10^9+7, or -1 if no non-negative product path exists.

## Constraints
- 1 <= m, n <= 15
- -4 <= grid[i][j] <= 4

## Examples
- Input: grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]] -> Output: -1
- Input: grid = [[1,-2,1],[1,-2,1],[3,-4,1]] -> Output: 8
- Input: grid = [[1,3],[0,-4]] -> Output: 0

## Notes
- DP tracking both max and min product at each cell; negative × negative can flip to best-case max.
- At each cell: candidates = {top_max, top_min, left_max, left_min} × grid[i][j]; take max and min.
- Final answer: if dp_max[m-1][n-1] < 0 return -1, else return it % (10^9+7).
- Time: O(m*n), Space: O(m*n).
