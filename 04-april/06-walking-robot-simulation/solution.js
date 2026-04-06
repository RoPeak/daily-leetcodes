var robotSim = function(commands, obstacles) {
    const obs = new Set(obstacles.map(([x, y]) => `${x},${y}`));
    // N, E, S, W
    const dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    let d = 0, x = 0, y = 0, ans = 0;
    for (const cmd of commands) {
        if (cmd === -1) {
            d = (d + 1) % 4;
        } else if (cmd === -2) {
            d = (d + 3) % 4;
        } else {
            const [dx, dy] = dirs[d];
            for (let i = 0; i < cmd; i++) {
                const nx = x + dx, ny = y + dy;
                if (obs.has(`${nx},${ny}`)) break;
                x = nx; y = ny;
                ans = Math.max(ans, x * x + y * y);
            }
        }
    }
    return ans;
};
