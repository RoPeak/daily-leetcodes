# 1886. Determine Whether Matrix Can Be Obtained By Rotation (Easy)
LeetCode: https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

## Summary
Check if `mat` can be rotated by 0°, 90°, 180°, or 270° to match `target`.

## Constraints
- `n == mat.length == mat[i].length == target.length == target[i].length`
- `1 <= n <= 10`
- `mat[i][j]` and `target[i][j]` are 0 or 1.

## Examples
- Input: `mat = [[0,1],[1,0]]`, `target = [[1,0],[0,1]]` → `true`
- Input: `mat = [[0,1],[1,1]]`, `target = [[1,0],[0,1]]` → `false`
- Input: `mat = [[0,0,0],[0,1,0],[1,1,1]]`, `target = [[1,1,1],[0,1,0],[0,0,0]]` → `true`

## Notes
- Rotate `mat` by transposing and reversing rows to produce each candidate.
- Compare each rotation with `target`.
