class Solution {
    private static class DSU {
        int[] parent;
        int[] size;
        int components;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) {
                return false;
            }
            if (size[ra] < size[rb]) {
                int tmp = ra;
                ra = rb;
                rb = tmp;
            }
            parent[rb] = ra;
            size[ra] += size[rb];
            components--;
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        java.util.ArrayList<int[]> mustEdges = new java.util.ArrayList<>();
        java.util.ArrayList<int[]> optionalEdges = new java.util.ArrayList<>();
        int hi = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];
            if (must == 1) {
                mustEdges.add(new int[]{u, v, s});
                hi = Math.max(hi, s);
            } else {
                optionalEdges.add(new int[]{u, v, s});
                hi = Math.max(hi, 2 * s);
            }
        }

        if (!feasible(1, n, k, mustEdges, optionalEdges)) {
            return -1;
        }

        int lo = 1;
        int ans = 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (feasible(mid, n, k, mustEdges, optionalEdges)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean feasible(int x, int n, int k, java.util.ArrayList<int[]> mustEdges,
                             java.util.ArrayList<int[]> optionalEdges) {
        DSU dsu = new DSU(n);

        for (int[] e : mustEdges) {
            int u = e[0], v = e[1], s = e[2];
            if (s < x) {
                return false;
            }
            if (!dsu.union(u, v)) {
                return false;
            }
        }

        for (int[] e : optionalEdges) {
            int u = e[0], v = e[1], s = e[2];
            if (s >= x) {
                dsu.union(u, v);
            }
        }

        int upgrades = 0;
        for (int[] e : optionalEdges) {
            int u = e[0], v = e[1], s = e[2];
            if (s < x && 2 * s >= x && dsu.union(u, v)) {
                upgrades++;
                if (upgrades > k) {
                    return false;
                }
            }
        }

        return dsu.components == 1;
    }
}
