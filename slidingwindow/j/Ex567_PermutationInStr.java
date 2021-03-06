package slidingwindow;

import java.util.HashMap;
// 判断条件放在后面
public class Ex567_PermutationInStr {
    public static void main(String args[]) {
        Ex567Solution sol = new Ex567Solution();
        String s1 = "adc";
        String s2 = "dcax";
        System.out.println(sol.checkInclusion(s1, s2));
    }
}

class Ex567Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s1.length(); i++) 
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);

        int startIdx = 0, cnt = s1.length();

        for (int endIdx = 0; endIdx < s2.length(); endIdx++) {
            
            char endChar = s2.charAt(endIdx);
            char startChar = s2.charAt(startIdx);
            if (endIdx >= s1.length()) {
                if (map.containsKey(startChar)) {
                    int startCnt = map.get(startChar);
                    if (startCnt >= 0)
                        cnt++;
                    map.put(startChar, startCnt + 1);
                }
                startIdx++;
            }
            
            if (map.containsKey(endChar)) {
                int endCnt = map.get(endChar);
                if (endCnt > 0)
                    cnt--;
                map.put(endChar, endCnt - 1);
            }
            if (cnt == 0)
                return true;
        }
        return false;
    }
}