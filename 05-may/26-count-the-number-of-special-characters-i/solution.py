class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        lowercase = set()
        uppercase = set()

        for ch in word:
            if "a" <= ch <= "z":
                lowercase.add(ch)
            else:
                uppercase.add(ch.lower())

        return sum(ch in uppercase for ch in lowercase)
