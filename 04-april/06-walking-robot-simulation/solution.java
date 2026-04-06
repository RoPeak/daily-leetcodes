class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> obs = new HashSet<>();
        for (int[] o : obstacles) {
            obs.add(encode(o[0], o[1]));
        }
        // N, E, S, W
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0, x = 0, y = 0, ans = 0;
        for (int cmd : commands) {
            if (cmd == -1) {
                d = (d + 1) % 4;
            } else if (cmd == -2) {
                d = (d + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (obs.contains(encode(nx, ny))) break;
                    x = nx; y = ny;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }

    private long encode(int x, int y) {
        return ((long)(x + 30001)) * 100003 + (y + 30001);
    }
}
