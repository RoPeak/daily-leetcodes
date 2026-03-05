# 2977. Minimum Cost to Convert String II (Hard)
LeetCode: https://leetcode.com/problems/minimum-cost-to-convert-string-ii/

## Summary
Transform source to target using substring conversions with costs, where operations must be disjoint or on identical ranges. Find the minimum total cost or return -1.

## Constraints
- 1 <= source.length == target.length <= 1000
- 1 <= cost.length == original.length == changed.length <= 100
- 1 <= original[i].length == changed[i].length <= source.length
- 1 <= cost[i] <= 1e6
- Strings use lowercase English letters

## Examples
- Input: source="abcd", target="acbe", original=["a","b","c","c","e","d"], changed=["b","c","b","e","b","e"], cost=[2,5,5,1,2,20] -> Output: 28
- Input: source="abcdefgh", target="acdeeghh", original=["bcd","fgh","thh"], changed=["cde","thh","ghh"], cost=[1,3,5] -> Output: 9
- Input: source="abcdefgh", target="addddddd", original=["bcd","defgh"], changed=["ddd","ddddd"], cost=[100,1578] -> Output: -1

## Notes
- Build a shortest-path graph over conversion strings, then do DP over positions using matching substrings.
