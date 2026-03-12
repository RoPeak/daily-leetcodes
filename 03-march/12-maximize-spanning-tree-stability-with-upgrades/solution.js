class DSU {
  constructor(n) {
    this.parent = Array.from({ length: n }, (_, i) => i);
    this.size = Array(n).fill(1);
    this.components = n;
  }

  find(x) {
    while (this.parent[x] !== x) {
      this.parent[x] = this.parent[this.parent[x]];
      x = this.parent[x];
    }
    return x;
  }

  union(a, b) {
    let ra = this.find(a);
    let rb = this.find(b);
    if (ra === rb) {
      return false;
    }
    if (this.size[ra] < this.size[rb]) {
      const tmp = ra;
      ra = rb;
      rb = tmp;
    }
    this.parent[rb] = ra;
    this.size[ra] += this.size[rb];
    this.components--;
    return true;
  }
}

/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number} k
 * @return {number}
 */
var maxStability = function(n, edges, k) {
  const mustEdges = [];
  const optionalEdges = [];
  let hi = 0;

  for (const [u, v, s, must] of edges) {
    if (must === 1) {
      mustEdges.push([u, v, s]);
      hi = Math.max(hi, s);
    } else {
      optionalEdges.push([u, v, s]);
      hi = Math.max(hi, 2 * s);
    }
  }

  const feasible = (x) => {
    const dsu = new DSU(n);

    for (const [u, v, s] of mustEdges) {
      if (s < x) {
        return false;
      }
      if (!dsu.union(u, v)) {
        return false;
      }
    }

    for (const [u, v, s] of optionalEdges) {
      if (s >= x) {
        dsu.union(u, v);
      }
    }

    let upgrades = 0;
    for (const [u, v, s] of optionalEdges) {
      if (s < x && 2 * s >= x && dsu.union(u, v)) {
        upgrades++;
        if (upgrades > k) {
          return false;
        }
      }
    }

    return dsu.components === 1;
  };

  if (!feasible(1)) {
    return -1;
  }

  let lo = 1;
  let ans = 1;
  while (lo <= hi) {
    const mid = (lo + hi) >> 1;
    if (feasible(mid)) {
      ans = mid;
      lo = mid + 1;
    } else {
      hi = mid - 1;
    }
  }

  return ans;
};
