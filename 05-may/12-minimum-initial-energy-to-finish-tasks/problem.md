# 1665. Minimum Initial Energy to Finish Tasks (Hard)
LeetCode: https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/

## Summary
Each task has an actual energy cost and a minimum energy needed before starting it. The tasks can be completed in any order, and the goal is to find the smallest initial energy that can finish all tasks.

## Constraints
- 1 <= tasks.length <= 10^5
- 1 <= actual_i <= minimum_i <= 10^4

## Examples
- Input: tasks=[[1,2],[2,4],[4,8]] -> Output: 8
- Input: tasks=[[1,3],[2,4],[10,11],[10,12],[8,9]] -> Output: 32
- Input: tasks=[[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]] -> Output: 27

## Notes
- Sort tasks by descending `minimum - actual`.
- For a fixed order, the initial energy must be at least `spent_before_task + minimum` for every task.
- Track the maximum of that value while accumulating the actual energy spent.
- The sort is justified by an exchange argument: for two adjacent tasks `a` and `b`, doing `a` first is no worse than doing `b` first when `a.minimum - a.actual >= b.minimum - b.actual`.
- Time complexity: `O(n log n)`. Space complexity: `O(1)` extra apart from sorting.
