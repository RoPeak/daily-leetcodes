class DSU:
    def __init__(self, n: int) -> None:
        self.parent = list(range(n))
        self.size = [1] * n
        self.components = n

    def find(self, x: int) -> int:
        while self.parent[x] != x:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x

    def union(self, a: int, b: int) -> bool:
        ra = self.find(a)
        rb = self.find(b)
        if ra == rb:
            return False
        if self.size[ra] < self.size[rb]:
            ra, rb = rb, ra
        self.parent[rb] = ra
        self.size[ra] += self.size[rb]
        self.components -= 1
        return True


class Solution:
    def maxStability(self, n: int, edges: list[list[int]], k: int) -> int:
        must_edges = []
        optional_edges = []
        hi = 0

        for u, v, s, must in edges:
            if must == 1:
                must_edges.append((u, v, s))
                hi = max(hi, s)
            else:
                optional_edges.append((u, v, s))
                hi = max(hi, 2 * s)

        def feasible(x: int) -> bool:
            dsu = DSU(n)

            for u, v, s in must_edges:
                if s < x:
                    return False
                if not dsu.union(u, v):
                    return False

            for u, v, s in optional_edges:
                if s >= x:
                    dsu.union(u, v)

            upgrades = 0
            for u, v, s in optional_edges:
                if s < x <= 2 * s and dsu.union(u, v):
                    upgrades += 1
                    if upgrades > k:
                        return False

            return dsu.components == 1

        if not feasible(1):
            return -1

        lo = 1
        ans = 1
        while lo <= hi:
            mid = (lo + hi) // 2
            if feasible(mid):
                ans = mid
                lo = mid + 1
            else:
                hi = mid - 1

        return ans
