class Solution {
    public int[] minBitwiseArray(java.util.List<Integer> nums) {
        int[] res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int p = nums.get(i);
            if ((p & 1) == 0) {
                res[i] = -1;
                continue;
            }
            int temp = p;
            int cnt = 0;
            while ((temp & 1) == 1) {
                cnt++;
                temp >>= 1;
            }
            res[i] = p - (1 << (cnt - 1));
        }
        return res;
    }
}
