# 3637. Trionic Array I (Easy)
LeetCode: https://leetcode.com/problems/trionic-array-i/

## Summary
Check if there exist indices 0 < p < q < n - 1 such that the array is strictly increasing up to p, strictly decreasing from p to q, then strictly increasing from q to the end.

## Constraints
- 3 <= n <= 100
- -1000 <= nums[i] <= 1000

## Examples
- Input: nums=[1,3,5,4,2,6] -> Output: true
- Input: nums=[2,1,3] -> Output: false

## Notes
- Scan once to identify the three strict segments and ensure each has length at least 1.
