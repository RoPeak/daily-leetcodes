class Solution {
    public int[] separateDigits(int[] nums) {
        int size = 0;
        for (int num : nums) {
            size += String.valueOf(num).length();
        }

        int[] answer = new int[size];
        int index = 0;
        for (int num : nums) {
            String digits = String.valueOf(num);
            for (int i = 0; i < digits.length(); i++) {
                answer[index++] = digits.charAt(i) - '0';
            }
        }
        return answer;
    }
}
