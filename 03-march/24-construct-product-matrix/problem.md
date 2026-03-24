# 2906. Construct Product Matrix (Medium)
LeetCode: https://leetcode.com/problems/construct-product-matrix/

## Summary
Build a matrix p where p[i][j] is the product of every element in grid except grid[i][j], taken mod 12345. Classic "product except self" extended to 2D by flattening.

## Constraints
- 1 <= n, m <= 10^5
- 2 <= n * m <= 10^5
- 1 <= grid[i][j] <= 10^9

## Examples
- Input: grid = [[1,2],[3,4]] -> Output: [[24,12],[8,6]]
- Input: grid = [[12345],[2],[1]] -> Output: [[2],[0],[0]]

## Notes
- Flatten grid to 1D, apply prefix-suffix product trick mod 12345, reshape result.
- prefix[k] = product of flat[0..k-1] % MOD; suffix[k] = product of flat[k+1..end] % MOD.
- p[k] = prefix[k] * suffix[k] % MOD.
- Time: O(n*m), Space: O(n*m).
