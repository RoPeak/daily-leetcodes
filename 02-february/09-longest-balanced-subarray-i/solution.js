/**
 * @param {number[]} nums
 * @return {number}
 */
var longestBalanced = function(nums) {
  const n = nums.length;
  let best = 0;

  for (let left = 0; left < n; left++) {
    const evenSeen = new Set();
    const oddSeen = new Set();

    for (let right = left; right < n; right++) {
      const value = nums[right];
      if (value % 2 === 0) {
        evenSeen.add(value);
      } else {
        oddSeen.add(value);
      }

      if (evenSeen.size === oddSeen.size) {
        best = Math.max(best, right - left + 1);
      }
    }
  }

  return best;
};
