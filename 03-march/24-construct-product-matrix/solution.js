var constructProductMatrix = function(grid) {
    const MOD = 12345;
    const n = grid.length, m = grid[0].length, N = n * m;
    const flat = grid.flat();
    const result = new Int32Array(N).fill(1);

    let prefix = 1;
    for (let k = 0; k < N; k++) {
        result[k] = prefix;
        prefix = prefix * flat[k] % MOD;
    }

    let suffix = 1;
    for (let k = N - 1; k >= 0; k--) {
        result[k] = result[k] * suffix % MOD;
        suffix = suffix * flat[k] % MOD;
    }

    const out = [];
    for (let i = 0; i < n; i++)
        out.push(Array.from(result.subarray(i * m, (i + 1) * m)));
    return out;
};
