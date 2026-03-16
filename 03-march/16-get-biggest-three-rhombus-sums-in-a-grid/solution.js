/**
 * @param {number[][]} grid
 * @return {number[]}
 */
var getBiggestThree = function(grid) {
  const rows = grid.length;
  const cols = grid[0].length;
  const seen = new Set();

  for (let r = 0; r < rows; r++) {
    for (let c = 0; c < cols; c++) {
      seen.add(grid[r][c]);
      const maxSize = Math.min(cols - 1 - c, c, Math.floor((rows - 1 - r) / 2));

      for (let size = 1; size <= maxSize; size++) {
        let total = 0;
        let x = r;
        let y = c;

        for (let step = 0; step < size; step++) {
          total += grid[x][y];
          x++;
          y++;
        }
        for (let step = 0; step < size; step++) {
          total += grid[x][y];
          x++;
          y--;
        }
        for (let step = 0; step < size; step++) {
          total += grid[x][y];
          x--;
          y--;
        }
        for (let step = 0; step < size; step++) {
          total += grid[x][y];
          x--;
          y++;
        }

        seen.add(total);
      }
    }
  }

  return [...seen].sort((a, b) => b - a).slice(0, 3);
};
