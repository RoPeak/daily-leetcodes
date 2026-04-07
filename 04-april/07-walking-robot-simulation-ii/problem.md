# 2069. Walking Robot Simulation II (Medium)

LeetCode: https://leetcode.com/problems/walking-robot-simulation-ii/

## Summary

Simulate a robot that walks only along the perimeter of a `width x height` grid. The robot starts at `(0, 0)` facing East and turns counterclockwise whenever the next forward cell would leave the grid.

## Constraints

- `2 <= width, height <= 100`
- `1 <= num <= 10^5`
- At most `10^4` total calls are made to `step`, `getPos`, and `getDir`

## Examples

- Input: `["Robot","step","step","getPos","getDir","step","step","step","getPos","getDir"]`, `[[6,3],[2],[2],[],[],[2],[1],[4],[],[]]` → Output: `[null,null,null,[4,0],"East",null,null,null,[1,2],"West"]`

## Notes

- After the first move, the robot always stays on the outer boundary, so its state can be represented by an index on the perimeter cycle.
- Let `perimeter = 2 * (width + height) - 4`; moving `num` steps is equivalent to moving `num % perimeter`, except that a positive multiple of the perimeter still completes one full loop.
- The position and direction can be reconstructed directly from the perimeter index.
- Special case: at index `0`, the initial direction is `East`, but after any positive full loop back to `(0, 0)` the direction is `South`.
- `step`: O(1), `getPos`: O(1), `getDir`: O(1)
