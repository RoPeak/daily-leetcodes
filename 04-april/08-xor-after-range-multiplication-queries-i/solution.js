var xorAfterQueries = function(nums, queries) {
    const MOD = 1_000_000_007n;
    const arr = nums.map(BigInt);
    for (const [l, r, k, v] of queries) {
        const bv = BigInt(v);
        for (let idx = l; idx <= r; idx += k) {
            arr[idx] = arr[idx] * bv % MOD;
        }
    }
    return arr.reduce((acc, x) => acc ^ x, 0n);
};
