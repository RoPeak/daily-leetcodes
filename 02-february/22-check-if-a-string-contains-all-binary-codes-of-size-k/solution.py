class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        n = len(s)
        need = 1 << k
        windows = n - k + 1
        if windows < need:
            return False

        seen = [False] * need
        mask = need - 1
        value = 0
        found = 0

        for i, ch in enumerate(s):
            value = ((value << 1) & mask) | (1 if ch == "1" else 0)
            if i >= k - 1 and not seen[value]:
                seen[value] = True
                found += 1
                if found == need:
                    return True

        return False
