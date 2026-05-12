from typing import List


class Solution:
    def minimumEffort(self, tasks: List[List[int]]) -> int:
        tasks.sort(key=lambda task: task[1] - task[0], reverse=True)

        spent = 0
        answer = 0

        for actual, minimum in tasks:
            answer = max(answer, spent + minimum)
            spent += actual

        return answer
