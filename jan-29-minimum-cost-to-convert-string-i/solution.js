/**
 * @param {string} source
 * @param {string} target
 * @param {string[]} original
 * @param {string[]} changed
 * @param {number[]} cost
 * @return {number}
 */
var minimumCost = function(source, target, original, changed, cost) {
  const INF = 1e18;
  const dist = Array.from({ length: 26 }, () => Array(26).fill(INF));
  for (let i = 0; i < 26; i++) dist[i][i] = 0;

  for (let i = 0; i < original.length; i++) {
    const u = original[i].charCodeAt(0) - 97;
    const v = changed[i].charCodeAt(0) - 97;
    if (cost[i] < dist[u][v]) dist[u][v] = cost[i];
  }

  for (let k = 0; k < 26; k++) {
    for (let i = 0; i < 26; i++) {
      if (dist[i][k] === INF) continue;
      for (let j = 0; j < 26; j++) {
        const nk = dist[i][k] + dist[k][j];
        if (nk < dist[i][j]) dist[i][j] = nk;
      }
    }
  }

  let total = 0;
  for (let i = 0; i < source.length; i++) {
    const s = source.charCodeAt(i) - 97;
    const t = target.charCodeAt(i) - 97;
    if (s === t) continue;
    if (dist[s][t] === INF) return -1;
    total += dist[s][t];
  }
  return total;
};
