package dp;

import java.util.List;

public class Ex120 {
    public static void main (String[] args) {

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        final int LENGTH = triangle.size();
        int[] dp = new int[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            List<Integer> list = triangle.get(i);
            int length = list.size();
            for (int j = length - 1; j >= 0; j--) 
                if (j == 0)
                    dp[j] = dp[j] + list.get(j);
                else if (j == length - 1)
                    dp[j] = dp[j - 1] + list.get(j);
                else
                    dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp)
            min = Math.min(i, min);
        return min;
    }
}