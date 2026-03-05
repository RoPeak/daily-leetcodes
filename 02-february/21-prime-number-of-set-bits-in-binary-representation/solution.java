class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;

        for (int num = left; num <= right; num++) {
            int bits = Integer.bitCount(num);
            if (isPrime(bits)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isPrime(int x) {
        return x == 2 || x == 3 || x == 5 || x == 7
                || x == 11 || x == 13 || x == 17 || x == 19;
    }
}
