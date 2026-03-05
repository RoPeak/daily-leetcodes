# 1382. Balance a Binary Search Tree (Medium)
LeetCode: https://leetcode.com/problems/balance-a-binary-search-tree/

## Summary
Given the root of a BST, return any height-balanced BST containing exactly the same node values.

## Constraints
- The number of nodes is in the range [1, 10^4]
- 1 <= Node.val <= 10^5

## Examples
- Input: root=[1,null,2,null,3,null,4,null,null] -> Output: [2,1,3,null,null,null,4]
- Input: root=[2,1,3] -> Output: [2,1,3]

## Notes
- Inorder traversal of a BST gives sorted values.
- Build a balanced BST by recursively choosing the middle value as root.
