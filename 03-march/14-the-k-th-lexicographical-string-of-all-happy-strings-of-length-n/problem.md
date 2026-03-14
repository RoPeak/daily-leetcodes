# 1415. The k-th Lexicographical String of All Happy Strings of Length n (Medium)
LeetCode: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

## Summary
Return the `k`th lexicographically smallest happy string of length `n`, or an empty string if fewer than `k` happy strings exist.

## Constraints
- 1 <= n <= 10
- 1 <= k <= 100

## Examples
- Input: n=1, k=3 -> Output: "c"
- Input: n=1, k=4 -> Output: ""
- Input: n=3, k=9 -> Output: "cab"

## Notes
- There are exactly `3 * 2^(n - 1)` happy strings of length `n`.
- Build the answer greedily: at each position, each valid next character contributes the same number of suffixes.
- Time complexity: O(n), space complexity: O(n).
