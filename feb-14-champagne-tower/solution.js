/**
 * @param {number} poured
 * @param {number} query_row
 * @param {number} query_glass
 * @return {number}
 */
var champagneTower = function(poured, query_row, query_glass) {
  let row = [poured];

  for (let r = 0; r < query_row; r++) {
    const next = new Array(row.length + 1).fill(0);
    for (let i = 0; i < row.length; i++) {
      const overflow = Math.max(0, row[i] - 1) / 2;
      if (overflow > 0) {
        next[i] += overflow;
        next[i + 1] += overflow;
      }
    }
    row = next;
  }

  return Math.min(1, row[query_glass]);
};
