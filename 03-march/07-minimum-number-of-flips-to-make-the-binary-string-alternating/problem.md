# 1888. Minimum Number of Flips to Make the Binary String Alternating (Medium)
LeetCode: https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/

## Summary
Given a binary string `s`, you may rotate it by moving the first character to the end any number of times, and flip any characters. Return the minimum number of flips needed to make the resulting string alternating.

## Constraints
- 1 <= s.length <= 10^5
- `s[i]` is either `'0'` or `'1'`

## Examples
- Input: s="111000" -> Output: 2
- Input: s="010" -> Output: 0
- Input: s="1110" -> Output: 1

## Notes
- Any rotation is a length-`n` window in the virtual string `s + s`.
- Track mismatches to both alternating targets (`0101...` and `1010...`) in a sliding window.
- Time complexity: O(n), space complexity: O(1).
