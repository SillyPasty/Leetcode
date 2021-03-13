package slidingwindow;

public class Ex1208GetEqualSubs {
    public static void main (String[] args) {
        String s = "abcd", t = "abcd";
        int maxCost = 0;
        Ex1208Solution sol = new Ex1208Solution();
        System.out.println(sol.equalSubstring(s, t, maxCost));
    }
}

class Ex1208Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int startIdx = 0, maxLen = 0, total = 0;
        for (int endIdx = 0; endIdx < t.length(); endIdx++) {
            int diff = Math.abs((int)(s.charAt(endIdx) - t.charAt(endIdx)));
            total += diff;
            if (total <= maxCost)
                maxLen = Math.max(maxLen, endIdx - startIdx + 1);
            else {
                diff = Math.abs((int)(s.charAt(startIdx) - t.charAt(startIdx)));
                total -= diff;
                startIdx++;
            }
        }
        return maxLen;
    }
}