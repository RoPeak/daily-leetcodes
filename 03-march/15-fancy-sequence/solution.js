const MOD = 1000000007n;
const MAX_N = 100000;

var Fancy = function() {
  const size = 4 * MAX_N + 5;
  this.tree = Array(size).fill(0n);
  this.lazyMul = Array(size).fill(1n);
  this.lazyAdd = Array(size).fill(0n);
  this.length = 0;
};

Fancy.prototype.apply = function(idx, mul, add) {
  this.tree[idx] = (this.tree[idx] * mul + add) % MOD;
  this.lazyMul[idx] = (this.lazyMul[idx] * mul) % MOD;
  this.lazyAdd[idx] = (this.lazyAdd[idx] * mul + add) % MOD;
};

Fancy.prototype.push = function(idx) {
  if (this.lazyMul[idx] === 1n && this.lazyAdd[idx] === 0n) {
    return;
  }
  this.apply(idx * 2, this.lazyMul[idx], this.lazyAdd[idx]);
  this.apply(idx * 2 + 1, this.lazyMul[idx], this.lazyAdd[idx]);
  this.lazyMul[idx] = 1n;
  this.lazyAdd[idx] = 0n;
};

Fancy.prototype.update = function(idx, left, right, ql, qr, mul, add) {
  if (ql <= left && right <= qr) {
    this.apply(idx, mul, add);
    return;
  }
  this.push(idx);
  const mid = Math.floor((left + right) / 2);
  if (ql <= mid) {
    this.update(idx * 2, left, mid, ql, qr, mul, add);
  }
  if (qr > mid) {
    this.update(idx * 2 + 1, mid + 1, right, ql, qr, mul, add);
  }
};

Fancy.prototype.assign = function(idx, left, right, pos, value) {
  if (left === right) {
    this.tree[idx] = BigInt(value) % MOD;
    return;
  }
  this.push(idx);
  const mid = Math.floor((left + right) / 2);
  if (pos <= mid) {
    this.assign(idx * 2, left, mid, pos, value);
  } else {
    this.assign(idx * 2 + 1, mid + 1, right, pos, value);
  }
};

Fancy.prototype.query = function(idx, left, right, pos) {
  if (left === right) {
    return this.tree[idx];
  }
  this.push(idx);
  const mid = Math.floor((left + right) / 2);
  if (pos <= mid) {
    return this.query(idx * 2, left, mid, pos);
  }
  return this.query(idx * 2 + 1, mid + 1, right, pos);
};

/**
 * @param {number} val
 * @return {void}
 */
Fancy.prototype.append = function(val) {
  this.assign(1, 0, MAX_N - 1, this.length, val);
  this.length++;
};

/**
 * @param {number} inc
 * @return {void}
 */
Fancy.prototype.addAll = function(inc) {
  if (this.length > 0) {
    this.update(1, 0, MAX_N - 1, 0, this.length - 1, 1n, BigInt(inc) % MOD);
  }
};

/**
 * @param {number} m
 * @return {void}
 */
Fancy.prototype.multAll = function(m) {
  if (this.length > 0) {
    this.update(1, 0, MAX_N - 1, 0, this.length - 1, BigInt(m) % MOD, 0n);
  }
};

/**
 * @param {number} idx
 * @return {number}
 */
Fancy.prototype.getIndex = function(idx) {
  if (idx >= this.length) {
    return -1;
  }
  return Number(this.query(1, 0, MAX_N - 1, idx));
};

/**
 * Your Fancy object will be instantiated and called as such:
 * var obj = new Fancy()
 * obj.append(val)
 * obj.addAll(inc)
 * obj.multAll(m)
 * var param_4 = obj.getIndex(idx)
 */
