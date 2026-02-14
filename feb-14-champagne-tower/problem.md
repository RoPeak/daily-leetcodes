# 799. Champagne Tower (Medium)
LeetCode: https://leetcode.com/problems/champagne-tower/

## Summary
Champagne is poured into the top glass of a triangular tower. Each glass holds 1 cup, and overflow splits equally to the two glasses below. Return how full the target glass is after all overflow propagates.

## Constraints
- 0 <= poured <= 10^9
- 0 <= query_glass <= query_row < 100

## Examples
- Input: poured=1, query_row=1, query_glass=1 -> Output: 0.00000
- Input: poured=2, query_row=1, query_glass=1 -> Output: 0.50000
- Input: poured=100000009, query_row=33, query_glass=17 -> Output: 1.00000

## Notes
- Use row-by-row DP where each entry stores current liquid amount before capping.
- Overflow from a glass is `max(0, amount - 1) / 2` and contributes to the two children.
- Time complexity: O(query_row^2). Space complexity: O(query_row).
