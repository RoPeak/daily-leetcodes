from typing import List


class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        cost.sort(reverse=True)

        answer = 0
        for i, price in enumerate(cost):
            if i % 3 != 2:
                answer += price

        return answer
