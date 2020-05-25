package slidingwindow;
// Can be optimized further, not use while to find next good string, use a List with pair.
import java.util.HashMap;

public class Ex12_MinimumWindowSubstring {
    public static void main(String args[]) {
        Ex12Solution sol = new Ex12Solution();
        String s = "ABCBECODEBANC";
        String t = "AA";
        System.out.println(sol.minWindow(s, t));
    }
}

class Ex12Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int pre = map.getOrDefault(t.charAt(i), -1);
            if (pre == -1)
                map.put(t.charAt(i), 1);
            else
                map.put(t.charAt(i), pre + 1);
        }
        int head = 0, minLen = s.length(), minH = 0, minT = 0, total = t.length();
        for (int tail = 0; tail < s.length(); tail++) {
            char curChar = s.charAt(tail);
            boolean flag = map.containsKey(curChar);
            if (flag) {
                int curNum = map.get(curChar);
                if (curNum > 0) {
                    total--;
                }
                map.put(curChar, curNum - 1);
            }
            char headChar = s.charAt(head);
            while ((!map.containsKey(headChar) || map.get(headChar) < 0) && head < tail) {
                if (map.containsKey(headChar) && map.get(headChar) < 0)
                    map.put(headChar, map.get(headChar) + 1);
                head++;
                headChar = s.charAt(head);
            }
            if (tail - head < minLen && total == 0) {
                minLen = tail - head + 1;
                minT = tail + 1;
                minH = head;
            }
        }
        return s.substring(minH, minT);
    }
}