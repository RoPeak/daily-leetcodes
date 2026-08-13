/**
 * @param {string} s
 * @param {string} queryCharacters
 * @param {number[]} queryIndices
 * @return {number[]}
 */
var longestRepeating = function(s, queryCharacters, queryIndices) {
    const arr = Array.from(s, ch => ch.charCodeAt(0) - 96);
    const n = arr.length;
    const tree = new Array(4 * n);

    function merge(leftNode, rightNode) {
        if (leftNode === null || leftNode === undefined) return rightNode;
        if (rightNode === null || rightNode === undefined) return leftNode;

        const merged = {
            length: leftNode.length + rightNode.length,
            left: leftNode.left,
            right: rightNode.right,
            best: Math.max(leftNode.best, rightNode.best),
            first: leftNode.first,
            last: rightNode.last
        };

        if (leftNode.left === leftNode.length && leftNode.last === rightNode.first) {
            merged.left = leftNode.length + rightNode.left;
        }

        if (rightNode.right === rightNode.length && rightNode.first === leftNode.last) {
            merged.right = rightNode.length + leftNode.right;
        }

        if (leftNode.last === rightNode.first) {
            merged.best = Math.max(merged.best, leftNode.right + rightNode.left);
        }

        return merged;
    }

    function build(node, left, right) {
        if (left === right) {
            const value = arr[left];
            tree[node] = { length: 1, left: 1, right: 1, best: 1, first: value, last: value };
            return;
        }

        const mid = Math.floor((left + right) / 2);
        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    function update(node, left, right, pos, val) {
        if (left === right) {
            tree[node] = { length: 1, left: 1, right: 1, best: 1, first: val, last: val };
            return;
        }

        const mid = Math.floor((left + right) / 2);
        if (pos <= mid) {
            update(node * 2, left, mid, pos, val);
        } else {
            update(node * 2 + 1, mid + 1, right, pos, val);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    build(1, 0, n - 1);

    const answer = [];
    for (let i = 0; i < queryCharacters.length; i++) {
        const pos = queryIndices[i];
        arr[pos] = queryCharacters.charCodeAt(i) - 96;
        update(1, 0, n - 1, pos, arr[pos]);
        answer.push(tree[1].best);
    }

    return answer;
};
