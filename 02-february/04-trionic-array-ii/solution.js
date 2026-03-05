/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSumTrionic = function(nums) {
  const n = nums.length;
  const NEG = -1e30;
  const inc = Array(n).fill(NEG);
  const dec = Array(n).fill(NEG);
  const tri = Array(n).fill(NEG);

  for (let i = 1; i < n; i++) {
    if (nums[i - 1] < nums[i]) {
      inc[i] = Math.max(inc[i - 1] + nums[i], nums[i - 1] + nums[i]);
    }

    if (nums[i - 1] > nums[i]) {
      if (inc[i - 1] > NEG) dec[i] = Math.max(dec[i], inc[i - 1] + nums[i]);
      if (dec[i - 1] > NEG) dec[i] = Math.max(dec[i], dec[i - 1] + nums[i]);
    }

    if (nums[i - 1] < nums[i]) {
      if (dec[i - 1] > NEG) tri[i] = Math.max(tri[i], dec[i - 1] + nums[i]);
      if (tri[i - 1] > NEG) tri[i] = Math.max(tri[i], tri[i - 1] + nums[i]);
    }
  }

  let best = NEG;
  for (const v of tri) best = Math.max(best, v);
  return best;
};
