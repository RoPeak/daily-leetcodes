# 3315. Construct the Minimum Bitwise Array II (Medium)
LeetCode: https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/

## Summary
For each prime in nums, find the smallest x such that x OR (x + 1) == nums[i], or -1 if impossible.

## Constraints
- 1 <= nums.length <= 100
- 2 <= nums[i] <= 1e9
- nums[i] is a prime number

## Examples
- Input: nums=[2,3,5,7] -> Output: [-1,1,4,3]
- Input: nums=[11,13,31] -> Output: [9,12,15]

## Notes
- If nums[i] is even, no solution since x OR (x + 1) is always odd.
- For odd nums[i], let t be the highest bit inside the trailing-ones suffix; answer is nums[i] - 2^t.
