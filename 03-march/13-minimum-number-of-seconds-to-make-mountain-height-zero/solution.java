class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int fastest = Integer.MAX_VALUE;
        for (int workerTime : workerTimes) {
            fastest = Math.min(fastest, workerTime);
        }

        long lo = 0;
        long hi = (long) fastest * mountainHeight * (mountainHeight + 1) / 2;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (feasible(mid, mountainHeight, workerTimes)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean feasible(long timeLimit, int mountainHeight, int[] workerTimes) {
        long removed = 0;
        for (int workerTime : workerTimes) {
            removed += maxUnits(timeLimit, workerTime, mountainHeight);
            if (removed >= mountainHeight) {
                return true;
            }
        }
        return false;
    }

    private int maxUnits(long timeLimit, int workerTime, int mountainHeight) {
        int lo = 0;
        int hi = mountainHeight;

        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            long need = (long) workerTime * mid * (mid + 1) / 2;
            if (need <= timeLimit) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
