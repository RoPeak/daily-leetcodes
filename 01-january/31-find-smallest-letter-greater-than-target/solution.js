/**
 * @param {character[]} letters
 * @param {character} target
 * @return {character}
 */
var nextGreatestLetter = function(letters, target) {
  let lo = 0;
  let hi = letters.length;
  while (lo < hi) {
    const mid = (lo + hi) >> 1;
    if (letters[mid] <= target) {
      lo = mid + 1;
    } else {
      hi = mid;
    }
  }
  return lo === letters.length ? letters[0] : letters[lo];
};
