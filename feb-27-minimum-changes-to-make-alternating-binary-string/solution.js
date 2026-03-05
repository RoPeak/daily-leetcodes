/**
 * @param {string} s
 * @return {number}
 */
var minOperations = function(s) {
  let mismatchStartZero = 0;

  for (let i = 0; i < s.length; i++) {
    const expected = (i % 2 === 0) ? 48 : 49;
    if (s.charCodeAt(i) !== expected) {
      mismatchStartZero++;
    }
  }

  return Math.min(mismatchStartZero, s.length - mismatchStartZero);
};
