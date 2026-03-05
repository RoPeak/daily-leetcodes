# 401. Binary Watch (Easy)
LeetCode: https://leetcode.com/problems/binary-watch/

## Summary
Return all valid watch times where exactly `turnedOn` LEDs are on. Hours range from 0 to 11 and minutes from 0 to 59.

## Constraints
- 0 <= turnedOn <= 10

## Examples
- Input: turnedOn=1 -> Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
- Input: turnedOn=9 -> Output: []

## Notes
- Enumerate all 12 * 60 possible times.
- Count set bits in `hour` and `minute`; keep times where the total equals `turnedOn`.
- Time complexity: O(720). Space complexity: O(answer size).
