# 2976. Minimum Cost to Convert String I (Medium)
LeetCode: https://leetcode.com/problems/minimum-cost-to-convert-string-i/

## Summary
Compute the minimum total cost to transform source into target using directed character conversions with given costs.

## Constraints
- 1 <= source.length == target.length <= 1e5
- 1 <= cost.length == original.length == changed.length <= 2000
- 1 <= cost[i] <= 1e6
- All characters are lowercase English letters

## Examples
- Input: source="abcd", target="acbe", original=["a","b","c","c","e","d"], changed=["b","c","b","e","b","e"], cost=[2,5,5,1,2,20] -> Output: 28
- Input: source="aaaa", target="bbbb", original=["a","c"], changed=["c","b"], cost=[1,2] -> Output: 12
- Input: source="abcd", target="abce", original=["a"], changed=["e"], cost=[10000] -> Output: -1

## Notes
- Model conversions as a directed weighted graph over 26 letters and run Floyd-Warshall to get all-pairs minimum costs.
