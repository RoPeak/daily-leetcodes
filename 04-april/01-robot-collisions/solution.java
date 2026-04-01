class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] robots = new Integer[n];
        for (int i = 0; i < n; i++) robots[i] = i;
        java.util.Arrays.sort(robots, (a, b) -> positions[a] - positions[b]);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i : robots) {
            if (directions.charAt(i) == 'R') {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && healths[i] > 0) {
                    int top = stack.peek();
                    if (healths[top] > healths[i]) {
                        healths[top]--;
                        healths[i] = 0;
                    } else if (healths[top] < healths[i]) {
                        healths[i]--;
                        healths[top] = 0;
                        stack.pop();
                    } else {
                        healths[top] = 0;
                        healths[i] = 0;
                        stack.pop();
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) result.add(healths[i]);
        }
        return result;
    }
}
