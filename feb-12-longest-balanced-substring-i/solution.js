/**
 * @param {string} s
 * @return {number}
 */
var longestBalanced = function(s) {
  const n = s.length;
  let best = 0;

  for (let left = 0; left < n; left++) {
    const counts = new Array(26).fill(0);
    const freqCount = new Map();

    for (let right = left; right < n; right++) {
      const idx = s.charCodeAt(right) - 97;
      const oldFreq = counts[idx];
      if (oldFreq > 0) {
        const oldCount = freqCount.get(oldFreq) - 1;
        if (oldCount === 0) {
          freqCount.delete(oldFreq);
        } else {
          freqCount.set(oldFreq, oldCount);
        }
      }

      counts[idx]++;
      const newFreq = counts[idx];
      freqCount.set(newFreq, (freqCount.get(newFreq) || 0) + 1);

      if (freqCount.size === 1) {
        best = Math.max(best, right - left + 1);
      }
    }
  }

  return best;
};
