class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder(Math.max(a.length(), b.length()) + 1);

        while (i >= 0 || j >= 0 || carry != 0) {
            int total = carry;
            if (i >= 0) {
                total += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                total += b.charAt(j) - '0';
                j--;
            }

            sb.append((char) ('0' + (total & 1)));
            carry = total >> 1;
        }

        return sb.reverse().toString();
    }
}
