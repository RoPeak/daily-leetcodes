# 2943. Maximize Area of Square Hole in Grid (Medium)
LeetCode: https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/description/?envType=daily-question&envId=2026-01-15

## Summary
Find the maximum square area after removing some allowed horizontal and vertical bars.

## Constraints
- 1 <= n, m <= 1e9
- 1 <= hBars.length, vBars.length <= 100
- 2 <= hBars[i] <= n + 1
- 2 <= vBars[i] <= m + 1
- All values in hBars and vBars are distinct

## Examples
- Input: n=2, m=1, hBars=[2,3], vBars=[2] -> Output: 4
- Input: n=1, m=1, hBars=[2], vBars=[2] -> Output: 4
- Input: n=2, m=3, hBars=[2,3], vBars=[2,4] -> Output: 4

## Notes
- Idea: the largest square side is (max consecutive removable hBars + 1) and (max consecutive removable vBars + 1)