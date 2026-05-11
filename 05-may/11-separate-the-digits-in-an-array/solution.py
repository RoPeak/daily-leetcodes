from typing import List


class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        answer = []
        for num in nums:
            for ch in str(num):
                answer.append(ord(ch) - ord("0"))
        return answer
