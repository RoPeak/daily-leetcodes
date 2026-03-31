class Solution:
    def checkStrings(self, s1: str, s2: str) -> bool:
        counts = [0] * 52

        for i, (char1, char2) in enumerate(zip(s1, s2)):
            offset = 26 if i & 1 else 0
            counts[offset + ord(char1) - ord("a")] += 1
            counts[offset + ord(char2) - ord("a")] -= 1

        return all(count == 0 for count in counts)
