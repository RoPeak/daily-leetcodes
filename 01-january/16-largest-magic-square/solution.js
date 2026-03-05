/**
 * @param {number[][]} grid
 * @return {number}
 */
var largestMagicSquare = function(grid) {
  const m = grid.length;
  const n = grid[0].length;
  const row = Array.from({ length: m }, () => Array(n + 1).fill(0));
  const col = Array.from({ length: m + 1 }, () => Array(n).fill(0));
  const d1 = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));
  const d2 = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      const val = grid[i][j];
      row[i][j + 1] = row[i][j] + val;
      col[i + 1][j] = col[i][j] + val;
      d1[i + 1][j + 1] = d1[i][j] + val;
      d2[i + 1][j] = d2[i][j + 1] + val;
    }
  }

  const rowSum = (i, c, k) => row[i][c + k] - row[i][c];
  const colSum = (r, j, k) => col[r + k][j] - col[r][j];
  const diag1Sum = (r, c, k) => d1[r + k][c + k] - d1[r][c];
  const diag2Sum = (r, c, k) => d2[r + k][c] - d2[r][c + k];

  for (let k = Math.min(m, n); k >= 2; k--) {
    for (let r = 0; r <= m - k; r++) {
      for (let c = 0; c <= n - k; c++) {
        const target = rowSum(r, c, k);
        if (diag1Sum(r, c, k) !== target || diag2Sum(r, c, k) !== target) continue;
        let ok = true;
        for (let i = r; i < r + k; i++) {
          if (rowSum(i, c, k) !== target) {
            ok = false;
            break;
          }
        }
        if (!ok) continue;
        for (let j = c; j < c + k; j++) {
          if (colSum(r, j, k) !== target) {
            ok = false;
            break;
          }
        }
        if (ok) return k;
      }
    }
  }
  return 1;
};
