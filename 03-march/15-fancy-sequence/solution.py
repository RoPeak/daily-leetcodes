MOD = 1_000_000_007
MAX_N = 100000


class Fancy:
    def __init__(self):
        size = 4 * MAX_N + 5
        self.tree = [0] * size
        self.lazy_mul = [1] * size
        self.lazy_add = [0] * size
        self.length = 0

    def _apply(self, idx: int, mul: int, add: int) -> None:
        self.tree[idx] = (self.tree[idx] * mul + add) % MOD
        self.lazy_mul[idx] = (self.lazy_mul[idx] * mul) % MOD
        self.lazy_add[idx] = (self.lazy_add[idx] * mul + add) % MOD

    def _push(self, idx: int) -> None:
        if self.lazy_mul[idx] == 1 and self.lazy_add[idx] == 0:
            return
        self._apply(idx * 2, self.lazy_mul[idx], self.lazy_add[idx])
        self._apply(idx * 2 + 1, self.lazy_mul[idx], self.lazy_add[idx])
        self.lazy_mul[idx] = 1
        self.lazy_add[idx] = 0

    def _update(self, idx: int, left: int, right: int, ql: int, qr: int, mul: int, add: int) -> None:
        if ql <= left and right <= qr:
            self._apply(idx, mul, add)
            return
        self._push(idx)
        mid = (left + right) // 2
        if ql <= mid:
            self._update(idx * 2, left, mid, ql, qr, mul, add)
        if qr > mid:
            self._update(idx * 2 + 1, mid + 1, right, ql, qr, mul, add)

    def _assign(self, idx: int, left: int, right: int, pos: int, value: int) -> None:
        if left == right:
            self.tree[idx] = value % MOD
            return
        self._push(idx)
        mid = (left + right) // 2
        if pos <= mid:
            self._assign(idx * 2, left, mid, pos, value)
        else:
            self._assign(idx * 2 + 1, mid + 1, right, pos, value)

    def _query(self, idx: int, left: int, right: int, pos: int) -> int:
        if left == right:
            return self.tree[idx]
        self._push(idx)
        mid = (left + right) // 2
        if pos <= mid:
            return self._query(idx * 2, left, mid, pos)
        return self._query(idx * 2 + 1, mid + 1, right, pos)

    def append(self, val: int) -> None:
        self._assign(1, 0, MAX_N - 1, self.length, val)
        self.length += 1

    def addAll(self, inc: int) -> None:
        if self.length > 0:
            self._update(1, 0, MAX_N - 1, 0, self.length - 1, 1, inc % MOD)

    def multAll(self, m: int) -> None:
        if self.length > 0:
            self._update(1, 0, MAX_N - 1, 0, self.length - 1, m % MOD, 0)

    def getIndex(self, idx: int) -> int:
        if idx >= self.length:
            return -1
        return self._query(1, 0, MAX_N - 1, idx)


# Your Fancy object will be instantiated and called as such:
# obj = Fancy()
# obj.append(val)
# obj.addAll(inc)
# obj.multAll(m)
# param_4 = obj.getIndex(idx)
