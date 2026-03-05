# 110. Balanced Binary Tree (Easy)
LeetCode: https://leetcode.com/problems/balanced-binary-tree/

## Summary
Determine whether a binary tree is height-balanced, meaning every node has left and right subtree heights differing by at most 1.

## Constraints
- The number of nodes is in the range [0, 5000]
- -1e4 <= Node.val <= 1e4

## Examples
- Input: root=[3,9,20,null,null,15,7] -> Output: true
- Input: root=[1,2,2,3,3,null,null,4,4] -> Output: false
- Input: root=[] -> Output: true

## Notes
- Use postorder DFS returning subtree height, and return a sentinel when an imbalance is found.
