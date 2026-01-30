import java.util.*;

class Solution {
    private static class TrieNode {
        int[] next = new int[26];
        int id = -1;
        TrieNode() {
            Arrays.fill(next, -1);
        }
    }

    private static class Trie {
        ArrayList<TrieNode> nodes = new ArrayList<>();
        Trie() {
            nodes.add(new TrieNode());
        }

        void insert(String s, int idx) {
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                int nxt = nodes.get(cur).next[c];
                if (nxt == -1) {
                    nxt = nodes.size();
                    nodes.get(cur).next[c] = nxt;
                    nodes.add(new TrieNode());
                }
                cur = nxt;
            }
            nodes.get(cur).id = idx;
        }

        HashMap<Integer, Integer> matchesAt(String s, int start) {
            int cur = 0;
            HashMap<Integer, Integer> res = new HashMap<>();
            for (int i = start; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                int nxt = nodes.get(cur).next[c];
                if (nxt == -1) break;
                cur = nxt;
                int id = nodes.get(cur).id;
                if (id != -1) {
                    res.put(i - start + 1, id);
                }
            }
            return res;
        }
    }

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        HashMap<String, Integer> uniq = new HashMap<>();
        ArrayList<String> items = new ArrayList<>();
        for (String s : original) {
            if (!uniq.containsKey(s)) {
                uniq.put(s, items.size());
                items.add(s);
            }
        }
        for (String s : changed) {
            if (!uniq.containsKey(s)) {
                uniq.put(s, items.size());
                items.add(s);
            }
        }

        int nNodes = items.size();
        long INF = (long) 1e18;
        long[][] dist = new long[nNodes][nNodes];
        for (int i = 0; i < nNodes; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = uniq.get(original[i]);
            int v = uniq.get(changed[i]);
            if (cost[i] < dist[u][v]) dist[u][v] = cost[i];
        }

        for (int k = 0; k < nNodes; k++) {
            for (int i = 0; i < nNodes; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < nNodes; j++) {
                    long nk = dist[i][k] + dist[k][j];
                    if (nk < dist[i][j]) dist[i][j] = nk;
                }
            }
        }

        Trie trie = new Trie();
        for (Map.Entry<String, Integer> e : uniq.entrySet()) {
            trie.insert(e.getKey(), e.getValue());
        }

        int n = source.length();
        HashMap<Integer, Integer>[] sourceMatches = new HashMap[n];
        HashMap<Integer, Integer>[] targetMatches = new HashMap[n];
        for (int i = 0; i < n; i++) {
            sourceMatches[i] = trie.matchesAt(source, i);
            targetMatches[i] = trie.matchesAt(target, i);
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            long best = INF;
            if (source.charAt(i) == target.charAt(i)) best = dp[i + 1];
            HashMap<Integer, Integer> smap = sourceMatches[i];
            HashMap<Integer, Integer> tmap = targetMatches[i];
            for (Map.Entry<Integer, Integer> e : smap.entrySet()) {
                Integer tid = tmap.get(e.getKey());
                if (tid == null) continue;
                long c = dist[e.getValue()][tid];
                if (c == INF) continue;
                long cand = dp[i + e.getKey()] + c;
                if (cand < best) best = cand;
            }
            dp[i] = best;
        }

        return dp[0] == INF ? -1 : dp[0];
    }
}
