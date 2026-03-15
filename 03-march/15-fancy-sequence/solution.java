class Fancy {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_N = 100000;

    private final long[] tree;
    private final long[] lazyMul;
    private final long[] lazyAdd;
    private int length;

    public Fancy() {
        int size = 4 * MAX_N + 5;
        tree = new long[size];
        lazyMul = new long[size];
        lazyAdd = new long[size];
        java.util.Arrays.fill(lazyMul, 1);
        length = 0;
    }

    private void apply(int idx, long mul, long add) {
        tree[idx] = (tree[idx] * mul + add) % MOD;
        lazyMul[idx] = (lazyMul[idx] * mul) % MOD;
        lazyAdd[idx] = (lazyAdd[idx] * mul + add) % MOD;
    }

    private void push(int idx) {
        if (lazyMul[idx] == 1 && lazyAdd[idx] == 0) {
            return;
        }
        apply(idx * 2, lazyMul[idx], lazyAdd[idx]);
        apply(idx * 2 + 1, lazyMul[idx], lazyAdd[idx]);
        lazyMul[idx] = 1;
        lazyAdd[idx] = 0;
    }

    private void update(int idx, int left, int right, int ql, int qr, long mul, long add) {
        if (ql <= left && right <= qr) {
            apply(idx, mul, add);
            return;
        }
        push(idx);
        int mid = left + (right - left) / 2;
        if (ql <= mid) {
            update(idx * 2, left, mid, ql, qr, mul, add);
        }
        if (qr > mid) {
            update(idx * 2 + 1, mid + 1, right, ql, qr, mul, add);
        }
    }

    private void assign(int idx, int left, int right, int pos, long value) {
        if (left == right) {
            tree[idx] = value % MOD;
            return;
        }
        push(idx);
        int mid = left + (right - left) / 2;
        if (pos <= mid) {
            assign(idx * 2, left, mid, pos, value);
        } else {
            assign(idx * 2 + 1, mid + 1, right, pos, value);
        }
    }

    private int query(int idx, int left, int right, int pos) {
        if (left == right) {
            return (int) tree[idx];
        }
        push(idx);
        int mid = left + (right - left) / 2;
        if (pos <= mid) {
            return query(idx * 2, left, mid, pos);
        }
        return query(idx * 2 + 1, mid + 1, right, pos);
    }

    public void append(int val) {
        assign(1, 0, MAX_N - 1, length, val);
        length++;
    }

    public void addAll(int inc) {
        if (length > 0) {
            update(1, 0, MAX_N - 1, 0, length - 1, 1, inc % MOD);
        }
    }

    public void multAll(int m) {
        if (length > 0) {
            update(1, 0, MAX_N - 1, 0, length - 1, m % MOD, 0);
        }
    }

    public int getIndex(int idx) {
        if (idx >= length) {
            return -1;
        }
        return query(1, 0, MAX_N - 1, idx);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
