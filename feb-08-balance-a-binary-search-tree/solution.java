import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return build(values, 0, values.size() - 1);
    }

    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    private TreeNode build(List<Integer> values, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = build(values, left, mid - 1);
        node.right = build(values, mid + 1, right);
        return node;
    }
}
