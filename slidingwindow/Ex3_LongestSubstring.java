package slidingwindow;

import java.util.HashMap;

public class Ex3_LongestSubstring {
    public static void main(String args[]) {
        Ex3Solution sol = new Ex3Solution();
        String s = new String("a");
        System.out.println(sol.lengthOfLongestSubstring(s));
    }
}

class Ex3Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0, lc = 0;
        HashMap<Character,Integer> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int tmp = hash.getOrDefault(c, -1);
            if(tmp != -1 && tmp >= lc)
                lc = tmp + 1;
            hash.put(c, i);
            result = Math.max(i - lc + 1, result);
        }
        return result;
    }
}