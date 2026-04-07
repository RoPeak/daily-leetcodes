from typing import List


class Robot:
    def __init__(self, width: int, height: int):
        self.width = width
        self.height = height
        self.perimeter = 2 * (width + height) - 4
        self.index = 0
        self.moved = False

    def step(self, num: int) -> None:
        self.moved = True
        steps = num % self.perimeter
        if steps == 0:
            steps = self.perimeter
        self.index = (self.index + steps) % self.perimeter

    def getPos(self) -> List[int]:
        return [self._get_x(), self._get_y()]

    def getDir(self) -> str:
        if self.index == 0:
            return "South" if self.moved else "East"
        if self.index < self.width:
            return "East"
        if self.index < self.width + self.height - 1:
            return "North"
        if self.index < 2 * self.width + self.height - 2:
            return "West"
        return "South"

    def _get_x(self) -> int:
        if self.index < self.width:
            return self.index
        if self.index < self.width + self.height - 1:
            return self.width - 1
        if self.index < 2 * self.width + self.height - 2:
            return 2 * self.width + self.height - 3 - self.index
        return 0

    def _get_y(self) -> int:
        if self.index < self.width:
            return 0
        if self.index < self.width + self.height - 1:
            return self.index - self.width + 1
        if self.index < 2 * self.width + self.height - 2:
            return self.height - 1
        return self.perimeter - self.index


# Your Robot object will be instantiated and called as such:
# obj = Robot(width, height)
# obj.step(num)
# param_2 = obj.getPos()
# param_3 = obj.getDir()
