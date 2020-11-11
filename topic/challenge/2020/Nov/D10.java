package topic.challenge

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

.2020.Nov;

public class D10 {
    // 514
    public int findRotateSteps(String ring, String key) {
        int keyLen = key.length();
        int ringLen = ring.length();
        int[][] dp = new int[keyLen][ringLen];
        List<Integer>[] position = new List[26];
        for (int i = 0; i < 26; i++) {
            position[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < ringLen; i++) {
            position[ring.charAt(i) - 'a'].add(i);
        }
        for (int i = 0; i < keyLen; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i : position[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, ringLen - i) + 1;
        }
        for (int i = 1; i < keyLen; i++) {
            for (int j : position[key.charAt(i) - 'a']) {
                for (int k : position[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j-k),ringLen - Math.abs(j-k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[keyLen-1]).min().getAsInt();
    }
}
