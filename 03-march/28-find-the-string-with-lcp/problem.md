# 2573. Find the String with LCP (Hard)

LeetCode: https://leetcode.com/problems/find-the-string-with-lcp/

## Summary
Given an n×n LCP matrix where `lcp[i][j]` is the longest common prefix length between `word[i..n-1]` and `word[j..n-1]`, return the lexicographically smallest string that produces this matrix, or `""` if none exists.

## Constraints
- `1 <= n == lcp.length == lcp[i].length <= 1000`
- `0 <= lcp[i][j] <= n`

## Examples
- `lcp = [[4,0,2,0],[0,3,0,1],[2,0,2,0],[0,1,0,1]]` → `"abab"`
- `lcp = [[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,1]]` → `"aaaa"`
- `lcp = [[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,3]]` → `""`

## Notes
- **Greedy build**: assign characters left to right; if `lcp[i][j] > 0` for any `j > i`, positions `i` and `j` must share the same character.
- **Validate**: use DP bottom-up (`dp[i][j] = dp[i+1][j+1] + 1` if chars match, else 0) to reconstruct the LCP matrix from the built string and compare against input.
- Returns `""` if >26 distinct characters needed or if the computed LCP doesn't match.
- Time: O(n²), Space: O(n²)
