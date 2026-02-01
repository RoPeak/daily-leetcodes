# 3010. Divide an Array Into Subarrays With Minimum Cost I (Easy)
LeetCode: https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/

## Summary
Partition the array into three contiguous subarrays covering the whole array, minimizing the sum of the first elements of each subarray.

## Constraints
- 3 <= n <= 50
- 1 <= nums[i] <= 50

## Examples
- Input: nums=[1,2,3,12] -> Output: 6
- Input: nums=[5,4,3] -> Output: 12
- Input: nums=[10,3,1,1] -> Output: 12

## Notes
- The cost is nums[0] plus the two smallest values among indices 1..n-1.
