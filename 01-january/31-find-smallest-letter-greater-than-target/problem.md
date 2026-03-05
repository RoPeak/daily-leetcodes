# 744. Find Smallest Letter Greater Than Target (Easy)
LeetCode: https://leetcode.com/problems/find-smallest-letter-greater-than-target/

## Summary
Return the smallest letter in a sorted array that is strictly greater than target, wrapping to the first element if needed.

## Constraints
- 2 <= letters.length <= 1e4
- letters[i] is a lowercase English letter
- letters is sorted in non-decreasing order
- letters contains at least two different characters
- target is a lowercase English letter

## Examples
- Input: letters=["c","f","j"], target="a" -> Output: "c"
- Input: letters=["c","f","j"], target="c" -> Output: "f"
- Input: letters=["x","x","y","y"], target="z" -> Output: "x"

## Notes
- Use binary search for the first letter greater than target; if none, return letters[0].
