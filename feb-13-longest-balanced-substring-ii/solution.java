class Solution {
    private static final int NOT_FOUND = Integer.MIN_VALUE;

    private static final class LongIntHashMap {
        private long[] keys;
        private int[] values;
        private boolean[] used;
        private int mask;
        private int size;
        private int threshold;

        LongIntHashMap(int expectedSize) {
            int cap = 1;
            while (cap < expectedSize * 2) {
                cap <<= 1;
            }
            keys = new long[cap];
            values = new int[cap];
            used = new boolean[cap];
            mask = cap - 1;
            threshold = (int) (cap * 0.7);
        }

        int get(long key) {
            int idx = mix(key) & mask;
            while (used[idx]) {
                if (keys[idx] == key) {
                    return values[idx];
                }
                idx = (idx + 1) & mask;
            }
            return NOT_FOUND;
        }

        void putIfAbsent(long key, int value) {
            if (size >= threshold) {
                rehash();
            }
            int idx = mix(key) & mask;
            while (used[idx]) {
                if (keys[idx] == key) {
                    return;
                }
                idx = (idx + 1) & mask;
            }
            used[idx] = true;
            keys[idx] = key;
            values[idx] = value;
            size++;
        }

        private void rehash() {
            long[] oldKeys = keys;
            int[] oldValues = values;
            boolean[] oldUsed = used;

            int newCap = keys.length << 1;
            keys = new long[newCap];
            values = new int[newCap];
            used = new boolean[newCap];
            mask = newCap - 1;
            threshold = (int) (newCap * 0.7);
            size = 0;

            for (int i = 0; i < oldKeys.length; i++) {
                if (oldUsed[i]) {
                    putIfAbsent(oldKeys[i], oldValues[i]);
                }
            }
        }

        private static int mix(long x) {
            x ^= (x >>> 33);
            x *= 0xff51afd7ed558ccdL;
            x ^= (x >>> 33);
            x *= 0xc4ceb9fe1a85ec53L;
            x ^= (x >>> 33);
            return (int) x;
        }
    }

    private long key(int x, int y) {
        return (((long) x) << 32) ^ (y & 0xffffffffL);
    }

    private int longestSingleChar(char[] s) {
        int best = 0;
        int run = 0;
        char prev = 0;
        for (char ch : s) {
            if (ch == prev) {
                run++;
            } else {
                run = 1;
                prev = ch;
            }
            if (run > best) {
                best = run;
            }
        }
        return best;
    }

    private int longestTwoChars(char[] s, char positive, char block) {
        int n = s.length;
        int offset = n;
        int[] first = new int[2 * n + 1];
        int[] seen = new int[2 * n + 1];
        int epoch = 1;
        int best = 0;

        int i = 0;
        while (i < n) {
            while (i < n && s[i] == block) {
                i++;
            }
            if (i == n) {
                break;
            }

            int segmentStart = i;
            int diff = 0;
            int idx = offset;
            seen[idx] = epoch;
            first[idx] = segmentStart - 1;

            while (i < n && s[i] != block) {
                diff += (s[i] == positive) ? 1 : -1;
                idx = diff + offset;
                if (seen[idx] == epoch) {
                    int len = i - first[idx];
                    if (len > best) {
                        best = len;
                    }
                } else {
                    seen[idx] = epoch;
                    first[idx] = i;
                }
                i++;
            }
            epoch++;
        }

        return best;
    }

    private int longestThreeChars(char[] s) {
        int n = s.length;
        int a = 0;
        int b = 0;
        int c = 0;
        int best = 0;

        LongIntHashMap first = new LongIntHashMap(n + 1);
        first.putIfAbsent(key(0, 0), 0);

        for (int i = 1; i <= n; i++) {
            char ch = s[i - 1];
            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else {
                c++;
            }

            long k = key(a - b, a - c);
            int pos = first.get(k);
            if (pos != NOT_FOUND) {
                int len = i - pos;
                if (len > best) {
                    best = len;
                }
            } else {
                first.putIfAbsent(k, i);
            }
        }

        return best;
    }

    public int longestBalanced(String s) {
        char[] arr = s.toCharArray();
        int best = 0;

        best = Math.max(best, longestSingleChar(arr));
        best = Math.max(best, longestTwoChars(arr, 'a', 'c')); // only a,b
        best = Math.max(best, longestTwoChars(arr, 'a', 'b')); // only a,c
        best = Math.max(best, longestTwoChars(arr, 'b', 'a')); // only b,c
        best = Math.max(best, longestThreeChars(arr));         // a,b,c

        return best;
    }
}
