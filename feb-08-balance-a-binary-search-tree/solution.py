# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        vals = []

        def inorder(node: TreeNode) -> None:
            if not node:
                return
            inorder(node.left)
            vals.append(node.val)
            inorder(node.right)

        def build(left: int, right: int) -> TreeNode:
            if left > right:
                return None

            mid = (left + right) // 2
            node = TreeNode(vals[mid])
            node.left = build(left, mid - 1)
            node.right = build(mid + 1, right)
            return node

        inorder(root)
        return build(0, len(vals) - 1)
