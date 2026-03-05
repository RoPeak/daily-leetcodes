/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isTrionic = function(nums) {
  const n = nums.length;
  let i = 0;
  while (i + 1 < n && nums[i] < nums[i + 1]) i++;
  const p = i;
  if (p === 0 || p === n - 1) return false;

  while (i + 1 < n && nums[i] > nums[i + 1]) i++;
  const q = i;
  if (q === p || q === n - 1) return false;

  while (i + 1 < n && nums[i] < nums[i + 1]) i++;
  return i === n - 1;
};
