import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007L;
        Set<Integer> hset = buildDiffSet(hFences, m);
        Set<Integer> vset = buildDiffSet(vFences, n);

        int best = -1;
        for (int d : hset) {
            if (vset.contains(d) && d > best) best = d;
        }
        if (best == -1) return -1;
        long area = (long) best * best;
        return (int) (area % MOD);
    }

    private Set<Integer> buildDiffSet(int[] arr, int limit) {
        int[] all = Arrays.copyOf(arr, arr.length + 2);
        all[arr.length] = 1;
        all[arr.length + 1] = limit;
        Arrays.sort(all);

        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < all.length; i++) {
            for (int j = i + 1; j < all.length; j++) {
                res.add(all[j] - all[i]);
            }
        }
        return res;
    }
}
