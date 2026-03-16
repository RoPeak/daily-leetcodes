# 1878. Get Biggest Three Rhombus Sums in a Grid (Medium)
LeetCode: https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/

## Summary
Given a grid, compute the three largest distinct sums of rhombus borders, where a rhombus may also have area `0` (a single cell).

## Constraints
- 1 <= m, n <= 50
- 1 <= grid[i][j] <= 10^5

## Examples
- Input: grid=[[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]] -> Output: [228,216,211]
- Input: grid=[[1,2,3],[4,5,6],[7,8,9]] -> Output: [20,9,8]
- Input: grid=[[7,7,7]] -> Output: [7]

## Notes
- Enumerate every possible top vertex and rhombus size.
- Size `0` rhombuses are single cells; larger rhombuses can be summed by walking their four border edges.
- With `m, n <= 50`, direct border enumeration is efficient enough.
