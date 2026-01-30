from typing import List, Dict, Tuple


class TrieNode:
    __slots__ = ("next", "id")

    def __init__(self) -> None:
        self.next = [-1] * 26
        self.id = -1


class Trie:
    def __init__(self) -> None:
        self.nodes = [TrieNode()]

    def insert(self, s: str, idx: int) -> None:
        cur = 0
        for ch in s:
            c = ord(ch) - 97
            nxt = self.nodes[cur].next[c]
            if nxt == -1:
                nxt = len(self.nodes)
                self.nodes[cur].next[c] = nxt
                self.nodes.append(TrieNode())
            cur = nxt
        self.nodes[cur].id = idx

    def matches_at(self, s: str, start: int) -> Dict[int, int]:
        cur = 0
        res: Dict[int, int] = {}
        for i in range(start, len(s)):
            c = ord(s[i]) - 97
            nxt = self.nodes[cur].next[c]
            if nxt == -1:
                break
            cur = nxt
            if self.nodes[cur].id != -1:
                res[i - start + 1] = self.nodes[cur].id
        return res


class Solution:
    def minimumCost(
        self,
        source: str,
        target: str,
        original: List[str],
        changed: List[str],
        cost: List[int],
    ) -> int:
        uniq: Dict[str, int] = {}
        items: List[str] = []
        for s in original + changed:
            if s not in uniq:
                uniq[s] = len(items)
                items.append(s)

        n_nodes = len(items)
        INF = 10**18
        dist = [[INF] * n_nodes for _ in range(n_nodes)]
        for i in range(n_nodes):
            dist[i][i] = 0

        for a, b, c in zip(original, changed, cost):
            u = uniq[a]
            v = uniq[b]
            if c < dist[u][v]:
                dist[u][v] = c

        for k in range(n_nodes):
            for i in range(n_nodes):
                if dist[i][k] == INF:
                    continue
                dik = dist[i][k]
                row = dist[i]
                krow = dist[k]
                for j in range(n_nodes):
                    nk = dik + krow[j]
                    if nk < row[j]:
                        row[j] = nk

        trie = Trie()
        for s, idx in uniq.items():
            trie.insert(s, idx)

        n = len(source)
        source_matches = [None] * n
        target_matches = [None] * n
        for i in range(n):
            source_matches[i] = trie.matches_at(source, i)
            target_matches[i] = trie.matches_at(target, i)

        dp = [INF] * (n + 1)
        dp[n] = 0
        for i in range(n - 1, -1, -1):
            best = INF
            if source[i] == target[i]:
                best = dp[i + 1]
            smap = source_matches[i]
            tmap = target_matches[i]
            for length, sid in smap.items():
                tid = tmap.get(length)
                if tid is None:
                    continue
                c = dist[sid][tid]
                if c == INF:
                    continue
                if dp[i + length] + c < best:
                    best = dp[i + length] + c
            dp[i] = best

        return -1 if dp[0] == INF else dp[0]
