/**
 * @param {number[]} arr
 * @return {number}
 */
var minJumps = function(arr) {
    const n = arr.length;
    if (n === 1) {
        return 0;
    }

    const indicesByValue = new Map();
    for (let i = 0; i < n; i++) {
        if (!indicesByValue.has(arr[i])) {
            indicesByValue.set(arr[i], []);
        }
        indicesByValue.get(arr[i]).push(i);
    }

    const queue = [0];
    const visited = Array(n).fill(false);
    visited[0] = true;
    let head = 0;
    let steps = 0;

    while (head < queue.length) {
        const levelEnd = queue.length;

        while (head < levelEnd) {
            const index = queue[head++];
            if (index === n - 1) {
                return steps;
            }

            const neighbors = indicesByValue.get(arr[index]);
            neighbors.push(index - 1, index + 1);

            for (const nextIndex of neighbors) {
                if (nextIndex >= 0 && nextIndex < n && !visited[nextIndex]) {
                    if (nextIndex === n - 1) {
                        return steps + 1;
                    }
                    visited[nextIndex] = true;
                    queue.push(nextIndex);
                }
            }

            neighbors.length = 0;
        }

        steps++;
    }

    return -1;
};
