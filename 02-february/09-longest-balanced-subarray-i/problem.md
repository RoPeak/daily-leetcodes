# 3719. Longest Balanced Subarray I (Medium)
LeetCode: https://leetcode.com/problems/longest-balanced-subarray-i/

## Summary
Find the maximum subarray length where the number of distinct even values equals the number of distinct odd values.

## Constraints
- 1 <= nums.length <= 1500
- 1 <= nums[i] <= 10^5

## Examples
- Input: nums=[2,5,4,3] -> Output: 4
- Input: nums=[3,2,2,5,4] -> Output: 5
- Input: nums=[1,2,3,2] -> Output: 3

## Notes
- For each starting index, expand the subarray and track distinct even and odd values with sets.
- Update the best length when the two distinct counts match.
