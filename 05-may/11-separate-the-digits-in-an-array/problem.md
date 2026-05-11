# 2553. Separate the Digits in an Array (Easy)
LeetCode: https://leetcode.com/problems/separate-the-digits-in-an-array/

## Summary
Build the answer by visiting each number in `nums` and appending its digits in left-to-right order. The final array preserves the original order across all numbers.

## Constraints
- 1 <= nums.length <= 1000
- 1 <= nums[i] <= 10^5

## Examples
- Input: nums=[13,25,83,77] -> Output: [1,3,2,5,8,3,7,7]
- Input: nums=[7,1,3,9] -> Output: [7,1,3,9]

## Notes
- Convert each number to its decimal representation, then append each character as a digit.
- This keeps the digits in the same order they appear inside each number.
- Time complexity: `O(totalDigits)`. Space complexity: `O(totalDigits)`.
