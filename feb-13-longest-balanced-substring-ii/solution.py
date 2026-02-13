class Solution:
    def longestBalanced(self, s: str) -> int:
        first_a = {(0, 0): 0}      # key: (b, c)
        first_b = {(0, 0): 0}      # key: (a, c)
        first_c = {(0, 0): 0}      # key: (a, b)
        first_ab = {(0, 0): 0}     # key: (a - b, c)
        first_ac = {(0, 0): 0}     # key: (a - c, b)
        first_bc = {(0, 0): 0}     # key: (b - c, a)
        first_abc = {(0, 0): 0}    # key: (a - b, a - c)

        a = b = c = 0
        best = 0

        for i, ch in enumerate(s, 1):
            if ch == "a":
                a += 1
            elif ch == "b":
                b += 1
            else:
                c += 1

            key = (b, c)
            if key in first_a:
                best = max(best, i - first_a[key])
            else:
                first_a[key] = i

            key = (a, c)
            if key in first_b:
                best = max(best, i - first_b[key])
            else:
                first_b[key] = i

            key = (a, b)
            if key in first_c:
                best = max(best, i - first_c[key])
            else:
                first_c[key] = i

            key = (a - b, c)
            if key in first_ab:
                best = max(best, i - first_ab[key])
            else:
                first_ab[key] = i

            key = (a - c, b)
            if key in first_ac:
                best = max(best, i - first_ac[key])
            else:
                first_ac[key] = i

            key = (b - c, a)
            if key in first_bc:
                best = max(best, i - first_bc[key])
            else:
                first_bc[key] = i

            key = (a - b, a - c)
            if key in first_abc:
                best = max(best, i - first_abc[key])
            else:
                first_abc[key] = i

        return best
