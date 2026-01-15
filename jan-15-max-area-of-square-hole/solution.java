import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int h = maxConsecutive(hBars) + 1;
        int v = maxConsecutive(vBars) + 1;
        int side = Math.min(h, v);
        return side * side;
    }

    private int maxConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        int best = 1;
        int cur = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                cur++;
            } else {
                if (cur > best) best = cur;
                cur = 1;
            }
        }
        if (cur > best) best = cur;
        return best;
    }
}
