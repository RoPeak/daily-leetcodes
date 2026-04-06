# 874. Walking Robot Simulation (Medium)

LeetCode: https://leetcode.com/problems/walking-robot-simulation/

## Summary

Simulate a robot on an infinite XY-plane starting at (0,0) facing north. Process turn and move commands while avoiding obstacles. Return the maximum squared Euclidean distance reached at any point.

## Constraints

- `1 <= commands.length <= 10^4`
- `commands[i]` is `-2`, `-1`, or `1..9`
- `0 <= obstacles.length <= 10^4`
- `-3 * 10^4 <= xi, yi <= 3 * 10^4`
- Answer < 2^31

## Examples

- Input: `commands = [4,-1,3], obstacles = []` → Output: `25`
- Input: `commands = [4,-1,4,-2,4], obstacles = [[2,4]]` → Output: `65`
- Input: `commands = [6,-1,-1,6], obstacles = [[0,0]]` → Output: `36`

## Notes

- Store obstacles in a hash set for O(1) lookup (encode as `"x,y"` string or tuple).
- Direction cycling: N→E→S→W with right turn `(d+1)%4`, left turn `(d+3)%4`.
- Move one step at a time, checking obstacle before each step.
- Track `max(x²+y²)` after each step.
- Time: O(C·K + O) where C = commands, K = max steps (9), O = obstacles.
