/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} dist
 * @return {number}
 */
var minimumCost = function(nums, k, dist) {
  const n = nums.length;
  const need = k - 2;
  if (need === 0) {
    let minRest = Infinity;
    for (let i = 1; i < n; i++) minRest = Math.min(minRest, nums[i]);
    return nums[0] + minRest;
  }

  const small = []; // max-heap via negative values
  const large = []; // min-heap
  const delayedSmall = new Map();
  const delayedLarge = new Map();
  let sizeSmall = 0;
  let sizeLarge = 0;
  let sumSmall = 0;

  const heapPush = (h, v) => {
    h.push(v);
    let i = h.length - 1;
    while (i > 0) {
      const p = (i - 1) >> 1;
      if (h[p] <= h[i]) break;
      [h[p], h[i]] = [h[i], h[p]];
      i = p;
    }
  };
  const heapPop = (h) => {
    const top = h[0];
    const last = h.pop();
    if (h.length) {
      h[0] = last;
      let i = 0;
      while (true) {
        let l = i * 2 + 1;
        let r = l + 1;
        let s = i;
        if (l < h.length && h[l] < h[s]) s = l;
        if (r < h.length && h[r] < h[s]) s = r;
        if (s === i) break;
        [h[i], h[s]] = [h[s], h[i]];
        i = s;
      }
    }
    return top;
  };

  const prune = (heap, delayed, sign) => {
    while (heap.length) {
      const val = heap[0] * sign;
      const cnt = delayed.get(val) || 0;
      if (cnt) {
        heapPop(heap);
        if (cnt === 1) delayed.delete(val);
        else delayed.set(val, cnt - 1);
      } else {
        break;
      }
    }
  };

  const getMaxSmall = () => {
    prune(small, delayedSmall, -1);
    return small.length ? -small[0] : null;
  };

  const rebalance = () => {
    prune(small, delayedSmall, -1);
    prune(large, delayedLarge, 1);
    while (sizeSmall > need) {
      const val = -heapPop(small);
      sumSmall -= val;
      sizeSmall--;
      heapPush(large, val);
      sizeLarge++;
      prune(small, delayedSmall, -1);
    }
    while (sizeSmall < need && large.length) {
      prune(large, delayedLarge, 1);
      if (!large.length) break;
      const val = heapPop(large);
      sizeLarge--;
      heapPush(small, -val);
      sizeSmall++;
      sumSmall += val;
      prune(large, delayedLarge, 1);
    }
  };

  const add = (x) => {
    if (sizeSmall < need) {
      heapPush(small, -x);
      sizeSmall++;
      sumSmall += x;
    } else {
      const maxSmall = getMaxSmall();
      if (maxSmall !== null && x < maxSmall) {
        heapPush(small, -x);
        sizeSmall++;
        sumSmall += x;
      } else {
        heapPush(large, x);
        sizeLarge++;
      }
    }
    rebalance();
  };

  const remove = (x) => {
    const maxSmall = getMaxSmall();
    if (maxSmall !== null && x <= maxSmall) {
      delayedSmall.set(x, (delayedSmall.get(x) || 0) + 1);
      sizeSmall--;
      sumSmall -= x;
      prune(small, delayedSmall, -1);
    } else {
      delayedLarge.set(x, (delayedLarge.get(x) || 0) + 1);
      sizeLarge--;
      prune(large, delayedLarge, 1);
    }
    rebalance();
  };

  const initialEnd = Math.min(n - 1, 1 + dist);
  for (let idx = 2; idx <= initialEnd; idx++) add(nums[idx]);

  let best = Infinity;
  for (let i1 = 1; i1 < n; i1++) {
    const start = i1 + 1;
    const end = Math.min(n - 1, i1 + dist);
    const windowLen = end - start + 1;
    if (windowLen >= need) {
      best = Math.min(best, nums[0] + nums[i1] + sumSmall);
    }

    if (i1 === n - 1) break;
    if (start <= n - 1) remove(nums[start]);
    const nextEnd = i1 + dist + 1;
    if (nextEnd <= n - 1) add(nums[nextEnd]);
  }

  return best;
};
