/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number}
 */
var minCost = function(grid, k) {
  const m = grid.length;
  const n = grid[0].length;
  let maxVal = 0;
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] > maxVal) maxVal = grid[i][j];
    }
  }
  const INF = 1e18;

  let dist = Array.from({ length: m }, () => Array(n).fill(INF));
  dist[0][0] = 0;
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (i === 0 && j === 0) continue;
      let best = INF;
      if (i > 0) best = Math.min(best, dist[i - 1][j] + grid[i][j]);
      if (j > 0) best = Math.min(best, dist[i][j - 1] + grid[i][j]);
      dist[i][j] = best;
    }
  }

  for (let step = 0; step < k; step++) {
    const minByVal = Array(maxVal + 1).fill(INF);
    for (let i = 0; i < m; i++) {
      for (let j = 0; j < n; j++) {
        const v = grid[i][j];
        if (dist[i][j] < minByVal[v]) minByVal[v] = dist[i][j];
      }
    }

    const suffix = Array(maxVal + 2).fill(INF);
    for (let v = maxVal; v >= 0; v--) {
      suffix[v] = Math.min(minByVal[v], suffix[v + 1]);
    }

    const newDist = Array.from({ length: m }, () => Array(n).fill(INF));
    for (let i = 0; i < m; i++) {
      for (let j = 0; j < n; j++) {
        newDist[i][j] = Math.min(dist[i][j], suffix[grid[i][j]]);
      }
    }

    for (let i = 0; i < m; i++) {
      for (let j = 0; j < n; j++) {
        if (i === 0 && j === 0) {
          newDist[i][j] = Math.min(newDist[i][j], 0);
          continue;
        }
        let best = newDist[i][j];
        if (i > 0) best = Math.min(best, newDist[i - 1][j] + grid[i][j]);
        if (j > 0) best = Math.min(best, newDist[i][j - 1] + grid[i][j]);
        newDist[i][j] = best;
      }
    }

    dist = newDist;
  }

  return dist[m - 1][n - 1];
};
