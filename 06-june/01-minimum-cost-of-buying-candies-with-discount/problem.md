# 2144. Minimum Cost of Buying Candies With Discount (Easy)
LeetCode: https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/

## Summary
To minimize the total cost, buy the most expensive candies first in groups of three. In each group, pay for the two highest costs and take the third one for free.

## Constraints
- `1 <= cost.length <= 100`
- `1 <= cost[i] <= 100`

## Examples
- Input: `cost = [1,2,3]` -> Output: `5`
- Input: `cost = [6,5,7,9,2,2]` -> Output: `23`
- Input: `cost = [5,5]` -> Output: `10`

## Notes
- Sort costs in descending order so every third candy is the cheapest within its paid pair.
- Add all candies except indices `2, 5, 8, ...` after sorting.
- This greedy choice maximizes the value of the free candies.
- Time complexity: `O(n log n)`. Space complexity: `O(1)` extra apart from sorting.
