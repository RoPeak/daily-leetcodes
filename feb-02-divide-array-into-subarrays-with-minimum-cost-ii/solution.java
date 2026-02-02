import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    private static class MultiSet {
        private final TreeMap<Integer, Integer> map = new TreeMap<>();
        private int size = 0;
        private long sum = 0;

        void add(int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            size++;
            sum += x;
        }

        void remove(int x) {
            Integer cnt = map.get(x);
            if (cnt == null) return;
            if (cnt == 1) map.remove(x);
            else map.put(x, cnt - 1);
            size--;
            sum -= x;
        }

        int size() {
            return size;
        }

        long sum() {
            return sum;
        }

        int first() {
            return map.firstKey();
        }

        int last() {
            return map.lastKey();
        }
    }

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int need = k - 2;
        if (need == 0) {
            int minRest = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) minRest = Math.min(minRest, nums[i]);
            return (long) nums[0] + minRest;
        }

        MultiSet small = new MultiSet(); // k-2 smallest
        MultiSet large = new MultiSet();

        Runnable rebalance = () -> {
            while (small.size() > need) {
                int val = small.last();
                small.remove(val);
                large.add(val);
            }
            while (small.size() < need && large.size() > 0) {
                int val = large.first();
                large.remove(val);
                small.add(val);
            }
        };

        java.util.function.IntConsumer add = (x) -> {
            if (small.size() < need) {
                small.add(x);
            } else if (small.size() > 0 && x < small.last()) {
                small.add(x);
            } else {
                large.add(x);
            }
            rebalance.run();
        };

        java.util.function.IntConsumer remove = (x) -> {
            if (small.size() > 0 && x <= small.last()) {
                small.remove(x);
            } else {
                large.remove(x);
            }
            rebalance.run();
        };

        int end = Math.min(n - 1, 1 + dist);
        for (int idx = 2; idx <= end; idx++) add.accept(nums[idx]);

        long best = Long.MAX_VALUE;
        for (int i1 = 1; i1 < n; i1++) {
            int start = i1 + 1;
            int endNow = Math.min(n - 1, i1 + dist);
            int windowLen = endNow - start + 1;
            if (windowLen >= need) {
                long cand = (long) nums[0] + nums[i1] + small.sum();
                if (cand < best) best = cand;
            }

            if (i1 == n - 1) break;
            if (start <= n - 1) remove.accept(nums[start]);
            int nextEnd = i1 + dist + 1;
            if (nextEnd <= n - 1) add.accept(nums[nextEnd]);
        }

        return best;
    }
}
