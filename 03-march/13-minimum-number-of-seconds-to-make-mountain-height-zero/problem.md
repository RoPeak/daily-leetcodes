# 3296. Minimum Number of Seconds to Make Mountain Height Zero (Medium)
LeetCode: https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/

## Summary
Given a mountain height and worker times, find the minimum time needed for all workers working in parallel to reduce the height to zero.

## Constraints
- 1 <= mountainHeight <= 10^5
- 1 <= workerTimes.length <= 10^4
- 1 <= workerTimes[i] <= 10^6

## Examples
- Input: mountainHeight=4, workerTimes=[2,1,1] -> Output: 3
- Input: mountainHeight=10, workerTimes=[3,2,2,4] -> Output: 12
- Input: mountainHeight=5, workerTimes=[1] -> Output: 15

## Notes
- Binary search the answer on time.
- For a fixed time `T`, each worker can reduce the height by the largest `x` such that `workerTime * x * (x + 1) / 2 <= T`.
- Sum all workers' contributions and check whether they can cover `mountainHeight`.
- Time complexity: O(m log A log H), where `m` is the number of workers, `A` is the answer range, and `H` is `mountainHeight`.
