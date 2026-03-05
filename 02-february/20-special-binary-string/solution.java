import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> parts = new ArrayList<>();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == '1' ? 1 : -1;
            if (balance == 0) {
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                parts.add("1" + inner + "0");
                start = i + 1;
            }
        }

        Collections.sort(parts, Collections.reverseOrder());
        StringBuilder ans = new StringBuilder();
        for (String part : parts) {
            ans.append(part);
        }
        return ans.toString();
    }
}
