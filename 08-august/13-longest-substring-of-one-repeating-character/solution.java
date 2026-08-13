class Solution {
    static class Node {
        int length;
        int left;
        int right;
        int best;
        int first;
        int last;

        Node(int length, int left, int right, int best, int first, int last) {
            this.length = length;
            this.left = left;
            this.right = right;
            this.best = best;
            this.first = first;
            this.last = last;
        }
    }

    private Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - 'a' + 1;
        }

        tree = new Node[4 * n];
        build(1, 0, n - 1, arr);

        int[] answer = new int[queryCharacters.length()];
        for (int i = 0; i < queryCharacters.length(); i++) {
            int idx = queryIndices[i];
            arr[idx] = queryCharacters.charAt(i) - 'a' + 1;
            update(1, 0, n - 1, idx, arr[idx]);
            answer[i] = tree[1].best;
        }
        return answer;
    }

    private void build(int node, int left, int right, int[] arr) {
        if (left == right) {
            int value = arr[left];
            tree[node] = new Node(1, 1, 1, 1, value, value);
            return;
        }

        int mid = (left + right) / 2;
        build(node * 2, left, mid, arr);
        build(node * 2 + 1, mid + 1, right, arr);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int left, int right, int pos, int val) {
        if (left == right) {
            tree[node] = new Node(1, 1, 1, 1, val, val);
            return;
        }

        int mid = (left + right) / 2;
        if (pos <= mid) {
            update(node * 2, left, mid, pos, val);
        } else {
            update(node * 2 + 1, mid + 1, right, pos, val);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node leftNode, Node rightNode) {
        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }

        Node merged = new Node(
            leftNode.length + rightNode.length,
            leftNode.left,
            rightNode.right,
            Math.max(leftNode.best, rightNode.best),
            leftNode.first,
            rightNode.last
        );

        if (leftNode.left == leftNode.length && leftNode.last == rightNode.first) {
            merged.left = leftNode.length + rightNode.left;
        }

        if (rightNode.right == rightNode.length && rightNode.first == leftNode.last) {
            merged.right = rightNode.length + leftNode.right;
        }

        if (leftNode.last == rightNode.first) {
            merged.best = Math.max(merged.best, leftNode.right + rightNode.left);
        }

        return merged;
    }
}
