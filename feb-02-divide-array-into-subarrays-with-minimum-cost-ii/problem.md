# 3013. Divide an Array Into Subarrays With Minimum Cost II (Hard)
LeetCode: https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/

## Summary
Split nums into k contiguous subarrays. The sum of the first elements of each subarray is the cost. The start index of the kth subarray must be within dist of the start index of the second subarray. Minimize the cost.

## Constraints
- 3 <= n <= 1e5
- 1 <= nums[i] <= 1e9
- 3 <= k <= n
- k - 2 <= dist <= n - 2

## Examples
- Input: nums=[1,3,2,6,4,2], k=3, dist=3 -> Output: 5
- Input: nums=[10,1,2,2,2,1], k=4, dist=3 -> Output: 15
- Input: nums=[10,8,18,9], k=3, dist=1 -> Output: 36

## Notes
- Fix the second subarray start i1; then choose the k-2 smallest values in (i1+1 .. i1+dist) for the remaining starts.
