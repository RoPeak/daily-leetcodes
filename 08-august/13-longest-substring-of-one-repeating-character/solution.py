from typing import List


class Node:
    __slots__ = ("length", "left", "right", "best", "first", "last")

    def __init__(self, length: int = 0, left: int = 0, right: int = 0, best: int = 0, first: int = 0, last: int = 0):
        self.length = length
        self.left = left
        self.right = right
        self.best = best
        self.first = first
        self.last = last


class Solution:
    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: List[int]) -> List[int]:
        arr = [ord(ch) - ord("a") + 1 for ch in s]
        n = len(arr)
        self.tree = [None] * (4 * n)
        self._build(1, 0, n - 1, arr)

        answer = []
        for ch, pos in zip(queryCharacters, queryIndices):
            arr[pos] = ord(ch) - ord("a") + 1
            self._update(1, 0, n - 1, pos, arr[pos])
            answer.append(self.tree[1].best)
        return answer

    def _build(self, node: int, left: int, right: int, arr: List[int]) -> None:
        if left == right:
            value = arr[left]
            self.tree[node] = Node(1, 1, 1, 1, value, value)
            return

        mid = (left + right) // 2
        self._build(node * 2, left, mid, arr)
        self._build(node * 2 + 1, mid + 1, right, arr)
        self.tree[node] = self._merge(self.tree[node * 2], self.tree[node * 2 + 1])

    def _update(self, node: int, left: int, right: int, pos: int, val: int) -> None:
        if left == right:
            self.tree[node] = Node(1, 1, 1, 1, val, val)
            return

        mid = (left + right) // 2
        if pos <= mid:
            self._update(node * 2, left, mid, pos, val)
        else:
            self._update(node * 2 + 1, mid + 1, right, pos, val)

        self.tree[node] = self._merge(self.tree[node * 2], self.tree[node * 2 + 1])

    @staticmethod
    def _merge(left_node: Node, right_node: Node) -> Node:
        if left_node is None:
            return right_node
        if right_node is None:
            return left_node

        merged = Node(
            left_node.length + right_node.length,
            left_node.left,
            right_node.right,
            max(left_node.best, right_node.best),
            left_node.first,
            right_node.last,
        )

        if left_node.left == left_node.length and left_node.last == right_node.first:
            merged.left = left_node.length + right_node.left

        if right_node.right == right_node.length and right_node.first == left_node.last:
            merged.right = right_node.length + left_node.right

        if left_node.last == right_node.first:
            merged.best = max(merged.best, left_node.right + right_node.left)

        return merged
