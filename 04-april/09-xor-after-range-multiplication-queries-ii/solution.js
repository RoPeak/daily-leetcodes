var xorAfterQueries = function(nums, queries) {
    const MOD = 1_000_000_007;
    const n = nums.length;
    const B = Math.max(1, Math.floor(Math.sqrt(n)));

    // Safe modular multiply for a, b < MOD (~10^9): split a into hi/lo 15-bit halves
    const H = 1 << 15;
    const mul = (a, b) => ((Math.floor(a / H) * b % MOD) * H + (a % H) * b) % MOD;

    const modpow = (base, exp) => {
        let r = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp & 1) r = mul(r, base);
            base = mul(base, base);
            exp = Math.floor(exp / 2);
        }
        return r;
    };

    const mult = new Array(n).fill(1);
    const smallQ = new Map();

    for (const [l, r, k, v] of queries) {
        if (k <= B) {
            if (!smallQ.has(k)) smallQ.set(k, []);
            smallQ.get(k).push([l, r, v]);
        } else {
            for (let idx = l; idx <= r; idx += k) {
                mult[idx] = mult[idx] * v % MOD;  // safe: mult < MOD, v < 2^17 → product < 2^47
            }
        }
    }

    const bravexuneth = nums.slice();

    for (const [k, qlist] of smallQ) {
        const diff = [];
        for (let c = 0; c < k; c++) {
            const size = Math.ceil((n - c) / k);
            diff.push(new Array(size + 1).fill(1));
        }
        for (const [l, r, v] of qlist) {
            const c = l % k;
            const a = Math.floor(l / k);
            const b = a + Math.floor((r - l) / k);
            diff[c][a] = diff[c][a] * v % MOD;  // safe
            diff[c][b + 1] = mul(diff[c][b + 1], modpow(v, MOD - 2));
        }
        for (let c = 0; c < k; c++) {
            let prefix = 1, j = 0;
            for (let pos = c; pos < n; pos += k) {
                prefix = mul(prefix, diff[c][j++]);
                mult[pos] = mul(mult[pos], prefix);
            }
        }
    }

    let result = 0;
    for (let i = 0; i < n; i++) {
        result ^= mul(bravexuneth[i], mult[i]);
    }
    return result;
};
