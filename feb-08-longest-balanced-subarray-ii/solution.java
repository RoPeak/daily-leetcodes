import java.util.Arrays;

class Solution {
    private int[] mn;
    private int[] mx;
    private int[] lazy;

    private void apply(int idx, int delta) {
        mn[idx] += delta;
        mx[idx] += delta;
        lazy[idx] += delta;
    }

    private void push(int idx) {
        int delta = lazy[idx];
        if (delta == 0) {
            return;
        }
        int left = idx << 1;
        int right = left | 1;

        mn[left] += delta;
        mx[left] += delta;
        lazy[left] += delta;

        mn[right] += delta;
        mx[right] += delta;
        lazy[right] += delta;

        lazy[idx] = 0;
    }

    private void pull(int idx) {
        int left = idx << 1;
        int right = left | 1;
        mn[idx] = Math.min(mn[left], mn[right]);
        mx[idx] = Math.max(mx[left], mx[right]);
    }

    private void rangeAdd(int idx, int l, int r, int ql, int qr, int delta) {
        if (ql <= l && r <= qr) {
            apply(idx, delta);
            return;
        }

        push(idx);
        int mid = (l + r) >>> 1;
        if (ql <= mid) {
            rangeAdd(idx << 1, l, mid, ql, qr, delta);
        }
        if (qr > mid) {
            rangeAdd((idx << 1) | 1, mid + 1, r, ql, qr, delta);
        }
        pull(idx);
    }

    private int firstZero(int idx, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            if (mn[idx] > 0 || mx[idx] < 0) {
                return -1;
            }
            if (l == r) {
                return l;
            }
        } else if (r < ql || l > qr) {
            return -1;
        }

        if (l == r) {
            return -1;
        }

        push(idx);
        int mid = (l + r) >>> 1;
        if (ql <= mid) {
            int leftRes = firstZero(idx << 1, l, mid, ql, qr);
            if (leftRes != -1) {
                return leftRes;
            }
        }
        if (qr > mid) {
            return firstZero((idx << 1) | 1, mid + 1, r, ql, qr);
        }
        return -1;
    }

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int size = n * 4;
        mn = new int[size];
        mx = new int[size];
        lazy = new int[size];

        int[] lastPos = new int[100001];
        Arrays.fill(lastPos, -1);

        int ans = 0;
        for (int r = 0; r < n; r++) {
            int x = nums[r];
            int left = lastPos[x] + 1;
            int delta = (x & 1) == 0 ? 1 : -1;

            rangeAdd(1, 0, n - 1, left, r, delta);
            lastPos[x] = r;

            int l = firstZero(1, 0, n - 1, 0, r);
            if (l != -1) {
                ans = Math.max(ans, r - l + 1);
            }
        }

        return ans;
    }
}
