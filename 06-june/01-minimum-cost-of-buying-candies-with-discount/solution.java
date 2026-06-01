import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int answer = 0;
        for (int i = cost.length - 1, taken = 0; i >= 0; i--, taken++) {
            if (taken % 3 != 2) {
                answer += cost[i];
            }
        }

        return answer;
    }
}
