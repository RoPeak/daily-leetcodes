# 2975. Maximum Square Area by Removing Fences From a Field (Medium)
LeetCode: https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/

## Summary
Find the largest square area that can be formed by removing some horizontal and vertical fences, or return -1 if impossible.

## Constraints
- 3 <= m, n <= 1e9
- 1 <= hFences.length, vFences.length <= 600
- 1 < hFences[i] < m
- 1 < vFences[i] < n
- hFences and vFences are unique

## Examples
- Input: m=4, n=3, hFences=[2,3], vFences=[2] -> Output: 4
- Input: m=6, n=7, hFences=[2], vFences=[4] -> Output: -1

## Notes
- Idea: compute all possible distances between fence lines in each direction and take the largest common distance.
