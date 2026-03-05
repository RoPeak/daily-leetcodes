/**
 * @param {number[]} nums
 * @return {number}
 */
var longestBalanced = function(nums) {
  const n = nums.length;
  const size = n * 4;
  const mn = new Int32Array(size);
  const mx = new Int32Array(size);
  const lazy = new Int32Array(size);

  const apply = (idx, delta) => {
    mn[idx] += delta;
    mx[idx] += delta;
    lazy[idx] += delta;
  };

  const push = (idx) => {
    const delta = lazy[idx];
    if (delta === 0) return;
    const left = idx << 1;
    const right = left | 1;
    mn[left] += delta;
    mx[left] += delta;
    lazy[left] += delta;
    mn[right] += delta;
    mx[right] += delta;
    lazy[right] += delta;
    lazy[idx] = 0;
  };

  const pull = (idx) => {
    const left = idx << 1;
    const right = left | 1;
    mn[idx] = mn[left] < mn[right] ? mn[left] : mn[right];
    mx[idx] = mx[left] > mx[right] ? mx[left] : mx[right];
  };

  const rangeAdd = (idx, l, r, ql, qr, delta) => {
    if (ql <= l && r <= qr) {
      apply(idx, delta);
      return;
    }
    push(idx);
    const mid = (l + r) >> 1;
    if (ql <= mid) rangeAdd(idx << 1, l, mid, ql, qr, delta);
    if (qr > mid) rangeAdd((idx << 1) | 1, mid + 1, r, ql, qr, delta);
    pull(idx);
  };

  const firstZero = (idx, l, r, ql, qr) => {
    if (ql <= l && r <= qr) {
      if (mn[idx] > 0 || mx[idx] < 0) return -1;
      if (l === r) return l;
    } else if (r < ql || l > qr) {
      return -1;
    }

    if (l === r) return -1;

    push(idx);
    const mid = (l + r) >> 1;
    if (ql <= mid) {
      const leftRes = firstZero(idx << 1, l, mid, ql, qr);
      if (leftRes !== -1) return leftRes;
    }
    if (qr > mid) return firstZero((idx << 1) | 1, mid + 1, r, ql, qr);
    return -1;
  };

  const lastPos = new Int32Array(100001);
  lastPos.fill(-1);

  let ans = 0;
  for (let r = 0; r < n; r++) {
    const x = nums[r];
    const left = lastPos[x] + 1;
    const delta = (x & 1) === 0 ? 1 : -1;
    rangeAdd(1, 0, n - 1, left, r, delta);
    lastPos[x] = r;

    const l = firstZero(1, 0, n - 1, 0, r);
    if (l !== -1) {
      const len = r - l + 1;
      if (len > ans) ans = len;
    }
  }

  return ans;
};
