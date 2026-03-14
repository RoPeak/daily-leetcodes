class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        total = 3 << (n - 1)
        if k > total:
            return ""

        chars = []
        prev = ""
        k -= 1

        for i in range(n):
            choices = [c for c in "abc" if c != prev]
            block = 1 << (n - i - 1)
            for ch in choices:
                if k >= block:
                    k -= block
                else:
                    chars.append(ch)
                    prev = ch
                    break

        return "".join(chars)
