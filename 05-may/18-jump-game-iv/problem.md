# 1345. Jump Game IV (Hard)
LeetCode: https://leetcode.com/problems/jump-game-iv/

## Summary
Starting at index `0`, each move can go to the previous index, the next index, or any other index with the same value. Return the minimum number of moves needed to reach the last index.

## Constraints
- 1 <= arr.length <= 5 * 10^4
- -10^8 <= arr[i] <= 10^8

## Examples
- Input: arr=[100,-23,-23,404,100,23,23,23,3,404] -> Output: 3
- Input: arr=[7] -> Output: 0
- Input: arr=[7,6,9,6,9,6,9,7] -> Output: 1

## Notes
- Model indices as graph nodes and use BFS, since every jump has equal cost.
- Precompute a map from value to all indices with that value.
- From each index, try `i - 1`, `i + 1`, and all indices sharing `arr[i]`.
- After processing all same-value jumps for a value, clear that bucket so the same group is never scanned again.
- Time complexity: `O(n)`. Space complexity: `O(n)`.
