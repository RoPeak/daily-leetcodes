from typing import List


class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        INF = 10**18
        dist = [[INF] * 26 for _ in range(26)]
        for i in range(26):
            dist[i][i] = 0

        for a, b, c in zip(original, changed, cost):
            u = ord(a) - 97
            v = ord(b) - 97
            if c < dist[u][v]:
                dist[u][v] = c

        for k in range(26):
            for i in range(26):
                if dist[i][k] == INF:
                    continue
                for j in range(26):
                    nk = dist[i][k] + dist[k][j]
                    if nk < dist[i][j]:
                        dist[i][j] = nk

        total = 0
        for s, t in zip(source, target):
            if s == t:
                continue
            u = ord(s) - 97
            v = ord(t) - 97
            if dist[u][v] == INF:
                return -1
            total += dist[u][v]

        return total
