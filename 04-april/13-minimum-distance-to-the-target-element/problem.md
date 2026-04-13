# 1848. Minimum Distance to the Target Element (Easy)

LeetCode: https://leetcode.com/problems/minimum-distance-to-the-target-element/

## Summary

Find the index `i` where `nums[i] == target` that minimises `abs(i - start)`. Return that minimum distance.

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 10^4`
- `0 <= start < nums.length`
- `target` is guaranteed to exist in `nums`

## Examples

- Input: `nums = [1,2,3,4,5], target = 5, start = 3` → Output: `1`
- Input: `nums = [1], target = 1, start = 0` → Output: `0`
- Input: `nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0` → Output: `0`

## Notes

- Single pass: track minimum `abs(i - start)` over all indices where `nums[i] == target`.
- Time: O(n), Space: O(1).
