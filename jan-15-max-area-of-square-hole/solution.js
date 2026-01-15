/**
 * @param {number} n
 * @param {number} m
 * @param {number[]} hBars
 * @param {number[]} vBars
 * @return {number}
 */
var maximizeSquareHoleArea = function(n, m, hBars, vBars) {
  const maxConsecutive = (arr) => {
    if (!arr || arr.length === 0) return 0;
    arr.sort((a, b) => a - b);
    let best = 1;
    let cur = 1;
    for (let i = 1; i < arr.length; i++) {
      if (arr[i] === arr[i - 1] + 1) {
        cur++;
      } else {
        if (cur > best) best = cur;
        cur = 1;
      }
    }
    if (cur > best) best = cur;
    return best;
  };

  const h = maxConsecutive(hBars) + 1;
  const v = maxConsecutive(vBars) + 1;
  const side = Math.min(h, v);
  return side * side;
};
