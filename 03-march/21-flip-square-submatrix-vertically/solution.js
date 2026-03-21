/**
 * @param {number[][]} grid
 * @param {number} x
 * @param {number} y
 * @param {number} k
 * @return {number[][]}
 */
var reverseSubmatrix = function(grid, x, y, k) {
  for (let rowOffset = 0; rowOffset < Math.floor(k / 2); rowOffset++) {
    const top = x + rowOffset;
    const bottom = x + k - 1 - rowOffset;
    for (let col = y; col < y + k; col++) {
      const tmp = grid[top][col];
      grid[top][col] = grid[bottom][col];
      grid[bottom][col] = tmp;
    }
  }
  return grid;
};
