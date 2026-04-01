# 2751. Robot Collisions (Hard)

LeetCode: https://leetcode.com/problems/robot-collisions/

## Summary
Robots move left/right on a line simultaneously. When an R and L robot collide, the lower-health one is removed and the survivor loses 1 health; equal health removes both. Return surviving robots' healths in original input order.

## Constraints
- 1 <= n <= 10^5
- 1 <= positions[i], healths[i] <= 10^9
- All positions are distinct

## Examples
- positions=[5,4,3,2,1], healths=[2,17,9,15,10], directions="RRRRR" → [2,17,9,15,10]
- positions=[3,5,2,6], healths=[10,10,15,12], directions="RLRL" → [14]
- positions=[1,2,5,6], healths=[10,10,11,11], directions="RLRL" → []

## Notes
- Sort robots by position; only R followed by L can collide.
- Stack holds indices of rightward robots; each L robot resolves against the stack.
- Collect survivors, sort by original index to restore input order.
- Complexity: O(n log n) time, O(n) space.
