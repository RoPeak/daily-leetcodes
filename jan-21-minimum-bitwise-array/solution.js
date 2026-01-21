/**
 * @param {number[]} nums
 * @return {number[]}
 */
var minBitwiseArray = function(nums) {
  const res = new Array(nums.length);
  for (let i = 0; i < nums.length; i++) {
    const p = nums[i];
    if ((p & 1) === 0) {
      res[i] = -1;
      continue;
    }
    let temp = p;
    let cnt = 0;
    while ((temp & 1) === 1) {
      cnt++;
      temp >>= 1;
    }
    res[i] = p - (1 << (cnt - 1));
  }
  return res;
};
