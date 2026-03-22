/**
 * @param {number[][]} mat
 * @param {number[][]} target
 * @return {boolean}
 */
var findRotation = function(mat, target) {
  const n = mat.length;

  const rotate = (matrix) => {
    const res = Array.from({ length: n }, () => Array(n).fill(0));
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        res[i][j] = matrix[n - 1 - j][i];
      }
    }
    return res;
  };

  for (let k = 0; k < 4; k++) {
    if (mat.every((row, i) => row.every((cell, j) => cell === target[i][j]))) {
      return true;
    }
    mat = rotate(mat);
  }

  return false;
};
