import java.util.Arrays;

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int spent = 0;
        int answer = 0;

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            answer = Math.max(answer, spent + minimum);
            spent += actual;
        }

        return answer;
    }
}
