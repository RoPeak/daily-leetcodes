/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number}
 */
var countSubmatrices = function (grid, k) {
  const m = grid.length;
  const n = grid[0].length;
  const col = new Array(n).fill(0);
  let ans = 0;

  for (let i = 0; i < m; i++) {
    let prefixSum = 0;
    for (let j = 0; j < n; j++) {
      col[j] += grid[i][j];
      prefixSum += col[j]; // sum of submatrix (0,0) to (i,j)
      if (prefixSum <= k) {
        ans++;
      }
    }
  }

  return ans;
};
