/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var countPrimeSetBits = function(left, right) {
  const primeCounts = new Set([2, 3, 5, 7, 11, 13, 17, 19]);
  let ans = 0;

  const bitCount = (x) => {
    let count = 0;
    while (x > 0) {
      x &= x - 1;
      count++;
    }
    return count;
  };

  for (let num = left; num <= right; num++) {
    if (primeCounts.has(bitCount(num))) {
      ans++;
    }
  }

  return ans;
};
