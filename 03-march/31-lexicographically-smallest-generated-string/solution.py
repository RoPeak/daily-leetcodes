class Solution:
    def generateString(self, str1: str, str2: str) -> str:
        n, m = len(str1), len(str2)
        L = n + m - 1
        word = ['a'] * L
        locked = [False] * L  # locked by a 'T' stamp

        # Stamp str2 at all 'T' positions, detect conflicts
        for i in range(n):
            if str1[i] == 'T':
                for j in range(m):
                    c = str2[j]
                    pos = i + j
                    if locked[pos] and word[pos] != c:
                        return ""
                    word[pos] = c
                    locked[pos] = True

        # For each 'F' position, ensure window != str2
        # If it matches, increment rightmost unlocked char in window
        for i in range(n):
            if str1[i] == 'F':
                # Check if word[i..i+m-1] == str2
                match = all(word[i + j] == str2[j] for j in range(m))
                if match:
                    # Find rightmost unlocked position in this window
                    fixed = False
                    for j in range(m - 1, -1, -1):
                        if not locked[i + j]:
                            word[i + j] = 'b'
                            fixed = True
                            break
                    if not fixed:
                        return ""

        # Final validation: re-check all 'F' windows
        for i in range(n):
            if str1[i] == 'F':
                if all(word[i + j] == str2[j] for j in range(m)):
                    return ""

        return ''.join(word)
