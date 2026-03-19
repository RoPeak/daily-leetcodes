/**
 * @param {character[][]} grid
 * @return {number}
 */
var numberOfSubmatrices = function(grid) {
  const cols = grid[0].length;
  const xCol = Array(cols).fill(0);
  const yCol = Array(cols).fill(0);
  let ans = 0;

  for (const row of grid) {
    let xPrefix = 0;
    let yPrefix = 0;

    for (let c = 0; c < cols; c++) {
      if (row[c] === 'X') {
        xCol[c]++;
      } else if (row[c] === 'Y') {
        yCol[c]++;
      }

      xPrefix += xCol[c];
      yPrefix += yCol[c];

      if (xPrefix > 0 && xPrefix === yPrefix) {
        ans++;
      }
    }
  }

  return ans;
};
