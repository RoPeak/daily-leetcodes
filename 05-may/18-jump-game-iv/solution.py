from collections import defaultdict, deque
from typing import List


class Solution:
    def minJumps(self, arr: List[int]) -> int:
        n = len(arr)
        if n == 1:
            return 0

        indices_by_value = defaultdict(list)
        for index, value in enumerate(arr):
            indices_by_value[value].append(index)

        queue = deque([0])
        visited = [False] * n
        visited[0] = True
        steps = 0

        while queue:
            for _ in range(len(queue)):
                index = queue.popleft()
                if index == n - 1:
                    return steps

                neighbors = indices_by_value[arr[index]]
                neighbors.append(index - 1)
                neighbors.append(index + 1)

                for next_index in neighbors:
                    if 0 <= next_index < n and not visited[next_index]:
                        if next_index == n - 1:
                            return steps + 1
                        visited[next_index] = True
                        queue.append(next_index)

                indices_by_value[arr[index]].clear()

            steps += 1

        return -1
