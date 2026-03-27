# 2946. Matrix Similarity After Cyclic Shifts (Easy)

LeetCode: https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/

## Summary
Given an m×n matrix, apply k cyclic shifts (even rows left, odd rows right). Return true if the result equals the original matrix.

## Constraints
- 1 <= mat.length <= 25
- 1 <= mat[i].length <= 25
- 1 <= mat[i][j] <= 25
- 1 <= k <= 50

## Examples
- mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4 → false
- mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2 → true
- mat = [[2,2],[2,2]], k = 3 → true

## Notes
After k shifts, each row is shifted by `k % n` positions (left for even rows, right for odd). Check each element in its shifted position against the original — rows with repeating patterns (e.g. `[1,2,1,2]`) can match even when `k % n != 0`.
- Time: O(m * n)
- Space: O(1)
