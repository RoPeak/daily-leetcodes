# 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold (Medium)
LeetCode: https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/

## Summary
Return the largest square side length in a matrix whose sum is at most the threshold.

## Constraints
- 1 <= m, n <= 300
- 0 <= mat[i][j] <= 1e4
- 0 <= threshold <= 1e5

## Examples
- Input: mat=[[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold=4 -> Output: 2
- Input: mat=[[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold=1 -> Output: 0

## Notes
- Idea: 2D prefix sums + binary search on side length.
