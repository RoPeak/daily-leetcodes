/**
 * @param {string} source
 * @param {string} target
 * @param {string[]} original
 * @param {string[]} changed
 * @param {number[]} cost
 * @return {number}
 */
var minimumCost = function(source, target, original, changed, cost) {
  const uniq = new Map();
  const items = [];
  const add = (s) => {
    if (!uniq.has(s)) {
      uniq.set(s, items.length);
      items.push(s);
    }
  };
  for (const s of original) add(s);
  for (const s of changed) add(s);

  const nNodes = items.length;
  const INF = 1e18;
  const dist = Array.from({ length: nNodes }, () => Array(nNodes).fill(INF));
  for (let i = 0; i < nNodes; i++) dist[i][i] = 0;

  for (let i = 0; i < original.length; i++) {
    const u = uniq.get(original[i]);
    const v = uniq.get(changed[i]);
    if (cost[i] < dist[u][v]) dist[u][v] = cost[i];
  }

  for (let k = 0; k < nNodes; k++) {
    for (let i = 0; i < nNodes; i++) {
      if (dist[i][k] === INF) continue;
      for (let j = 0; j < nNodes; j++) {
        const nk = dist[i][k] + dist[k][j];
        if (nk < dist[i][j]) dist[i][j] = nk;
      }
    }
  }

  const nodes = [{ next: Array(26).fill(-1), id: -1 }];
  const insert = (s, id) => {
    let cur = 0;
    for (let i = 0; i < s.length; i++) {
      const c = s.charCodeAt(i) - 97;
      let nxt = nodes[cur].next[c];
      if (nxt === -1) {
        nxt = nodes.length;
        nodes[cur].next[c] = nxt;
        nodes.push({ next: Array(26).fill(-1), id: -1 });
      }
      cur = nxt;
    }
    nodes[cur].id = id;
  };
  for (const [s, id] of uniq.entries()) insert(s, id);

  const matchesAt = (s, start) => {
    let cur = 0;
    const res = new Map();
    for (let i = start; i < s.length; i++) {
      const c = s.charCodeAt(i) - 97;
      const nxt = nodes[cur].next[c];
      if (nxt === -1) break;
      cur = nxt;
      if (nodes[cur].id !== -1) res.set(i - start + 1, nodes[cur].id);
    }
    return res;
  };

  const n = source.length;
  const sourceMatches = Array(n);
  const targetMatches = Array(n);
  for (let i = 0; i < n; i++) {
    sourceMatches[i] = matchesAt(source, i);
    targetMatches[i] = matchesAt(target, i);
  }

  const dp = Array(n + 1).fill(INF);
  dp[n] = 0;
  for (let i = n - 1; i >= 0; i--) {
    let best = INF;
    if (source[i] === target[i]) best = dp[i + 1];
    const smap = sourceMatches[i];
    const tmap = targetMatches[i];
    for (const [len, sid] of smap.entries()) {
      const tid = tmap.get(len);
      if (tid === undefined) continue;
      const c = dist[sid][tid];
      if (c === INF) continue;
      const cand = dp[i + len] + c;
      if (cand < best) best = cand;
    }
    dp[i] = best;
  }

  return dp[0] === INF ? -1 : dp[0];
};
