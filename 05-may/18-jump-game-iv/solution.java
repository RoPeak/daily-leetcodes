import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> indicesByValue = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indicesByValue.computeIfAbsent(arr[i], key -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int index = queue.poll();
                if (index == n - 1) {
                    return steps;
                }

                List<Integer> neighbors = indicesByValue.get(arr[index]);
                neighbors.add(index - 1);
                neighbors.add(index + 1);

                for (int nextIndex : neighbors) {
                    if (nextIndex >= 0 && nextIndex < n && !visited[nextIndex]) {
                        if (nextIndex == n - 1) {
                            return steps + 1;
                        }
                        visited[nextIndex] = true;
                        queue.offer(nextIndex);
                    }
                }

                neighbors.clear();
            }

            steps++;
        }

        return -1;
    }
}
