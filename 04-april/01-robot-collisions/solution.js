var survivedRobotsHealths = function(positions, healths, directions) {
    const n = positions.length;
    const robots = Array.from({length: n}, (_, i) => i).sort((a, b) => positions[a] - positions[b]);
    const h = [...healths];
    const stack = [];

    for (const i of robots) {
        if (directions[i] === 'R') {
            stack.push(i);
        } else {
            while (stack.length && h[i] > 0) {
                const top = stack[stack.length - 1];
                if (h[top] > h[i]) {
                    h[top]--;
                    h[i] = 0;
                } else if (h[top] < h[i]) {
                    h[i]--;
                    h[top] = 0;
                    stack.pop();
                } else {
                    h[top] = 0;
                    h[i] = 0;
                    stack.pop();
                }
            }
        }
    }

    return h.filter(x => x > 0);
};
