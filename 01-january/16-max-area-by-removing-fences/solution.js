/**
 * @param {number} m
 * @param {number} n
 * @param {number[]} hFences
 * @param {number[]} vFences
 * @return {number}
 */
var maximizeSquareArea = function(m, n, hFences, vFences) {
  const MOD = 1000000007n;

  const buildDiffSet = (arr, limit) => {
    const all = arr.slice();
    all.push(1, limit);
    all.sort((a, b) => a - b);
    const set = new Set();
    for (let i = 0; i < all.length; i++) {
      for (let j = i + 1; j < all.length; j++) {
        set.add(all[j] - all[i]);
      }
    }
    return set;
  };

  const hSet = buildDiffSet(hFences, m);
  const vSet = buildDiffSet(vFences, n);

  let best = -1;
  for (const d of hSet) {
    if (vSet.has(d) && d > best) best = d;
  }
  if (best === -1) return -1;

  const side = BigInt(best);
  return Number((side * side) % MOD);
};
