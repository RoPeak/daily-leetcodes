/**
 * @param {number[][]} mat
 * @param {number} threshold
 * @return {number}
 */
var maxSideLength = function(mat, threshold) {
  const m = mat.length;
  const n = mat[0].length;

  const ps = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));
  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      ps[i][j] =
        mat[i - 1][j - 1] +
        ps[i - 1][j] +
        ps[i][j - 1] -
        ps[i - 1][j - 1];
    }
  }

  const squareSum = (r, c, k) => {
    const r2 = r + k;
    const c2 = c + k;
    return ps[r2][c2] - ps[r][c2] - ps[r2][c] + ps[r][c];
  };

  let lo = 0;
  let hi = Math.min(m, n);
  while (lo < hi) {
    const mid = Math.floor((lo + hi + 1) / 2);
    let ok = false;
    for (let i = 0; i + mid <= m && !ok; i++) {
      for (let j = 0; j + mid <= n; j++) {
        if (squareSum(i, j, mid) <= threshold) {
          ok = true;
          break;
        }
      }
    }
    if (ok) lo = mid;
    else hi = mid - 1;
  }
  return lo;
};
