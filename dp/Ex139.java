package dp;

import java.util.Arrays;
import java.util.List;

public class Ex139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        final int LENGTH = s.length();
        boolean[] dp = new boolean[LENGTH + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= LENGTH; i++) {
            for (String subS : wordDict) {
                int length = subS.length();
                int startIndex = i - length;
                if (startIndex >= 0)
                    if (subS.equals(s.substring(startIndex, i)) && dp[i] == false)
                        dp[i] = dp[startIndex];
            }
        }
        return dp[LENGTH];
    }
}