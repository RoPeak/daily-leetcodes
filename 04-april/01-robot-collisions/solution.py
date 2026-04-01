class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        n = len(positions)
        robots = sorted(range(n), key=lambda i: positions[i])
        stack = []  # indices (in original array) of active rightward robots
        healths = list(healths)

        for i in robots:
            if directions[i] == 'R':
                stack.append(i)
            else:  # 'L' — may collide with rightward robots in stack
                while stack and healths[i] > 0:
                    top = stack[-1]
                    if healths[top] > healths[i]:
                        healths[top] -= 1
                        healths[i] = 0
                    elif healths[top] < healths[i]:
                        healths[i] -= 1
                        healths[top] = 0
                        stack.pop()
                    else:  # equal — both die
                        healths[top] = 0
                        healths[i] = 0
                        stack.pop()

        return [healths[i] for i in range(n) if healths[i] > 0]
