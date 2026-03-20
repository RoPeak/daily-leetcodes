/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number[][]}
 */
var minAbsDiff = function(grid, k) {
  const rows = grid.length;
  const cols = grid[0].length;
  const ans = [];

  for (let i = 0; i <= rows - k; i++) {
    const rowAns = [];
    for (let j = 0; j <= cols - k; j++) {
      const values = [];
      const seen = new Set();
      for (let x = i; x < i + k; x++) {
        for (let y = j; y < j + k; y++) {
          const val = grid[x][y];
          if (!seen.has(val)) {
            seen.add(val);
            values.push(val);
          }
        }
      }
      if (values.length <= 1) {
        rowAns.push(0);
      } else {
        values.sort((a, b) => a - b);
        let diff = Number.MAX_SAFE_INTEGER;
        for (let m = 0; m < values.length - 1; m++) {
          diff = Math.min(diff, values[m + 1] - values[m]);
        }
        rowAns.push(diff);
      }
    }
    ans.push(rowAns);
  }

  return ans;
};
