/**
 * @param {string} s
 * @param {number} k
 * @return {boolean}
 */
var hasAllCodes = function(s, k) {
  const n = s.length;
  const need = 1 << k;
  const windows = n - k + 1;
  if (windows < need) {
    return false;
  }

  const seen = new Uint8Array(need);
  const mask = need - 1;
  let value = 0;
  let found = 0;

  for (let i = 0; i < n; i++) {
    value = ((value << 1) & mask) | (s.charCodeAt(i) - 48);
    if (i >= k - 1 && seen[value] === 0) {
      seen[value] = 1;
      found++;
      if (found === need) {
        return true;
      }
    }
  }

  return false;
};
