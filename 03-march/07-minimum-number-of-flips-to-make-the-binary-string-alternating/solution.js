/**
 * @param {string} s
 * @return {number}
 */
var minFlips = function(s) {
  const n = s.length;
  let diff0 = 0;
  let diff1 = 0;
  let ans = n;

  for (let i = 0; i < 2 * n; i++) {
    const ch = s.charCodeAt(i % n);
    const expected0 = (i % 2 === 0) ? 48 : 49;
    const expected1 = (i % 2 === 0) ? 49 : 48;

    if (ch !== expected0) diff0++;
    if (ch !== expected1) diff1++;

    if (i >= n) {
      const left = s.charCodeAt((i - n) % n);
      const leftExpected0 = ((i - n) % 2 === 0) ? 48 : 49;
      const leftExpected1 = ((i - n) % 2 === 0) ? 49 : 48;
      if (left !== leftExpected0) diff0--;
      if (left !== leftExpected1) diff1--;
    }

    if (i >= n - 1) {
      ans = Math.min(ans, diff0, diff1);
    }
  }

  return ans;
};
