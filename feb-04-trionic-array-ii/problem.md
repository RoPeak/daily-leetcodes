# 3640. Trionic Array II (Hard)
LeetCode: https://leetcode.com/problems/trionic-array-ii/

## Summary
Find the maximum sum of a contiguous subarray that is strictly increasing, then strictly decreasing, then strictly increasing.

## Constraints
- 4 <= n <= 1e5
- -1e9 <= nums[i] <= 1e9
- At least one trionic subarray exists

## Examples
- Input: nums=[0,-2,-1,-3,0,2,-1] -> Output: -4
- Input: nums=[1,4,2,7] -> Output: 14

## Notes
- Use DP for three phases: increasing, then decreasing, then increasing, tracking max sums ending at each index.
