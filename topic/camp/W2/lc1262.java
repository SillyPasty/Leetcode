public class lc1262 {
    public int maxSumDivThree(int[] nums) {
        int[] dp = {0, 0, 0};
        for (int x : nums) {
            int mod = x % 3;
            int x0 = dp[(3 + 0 - mod) % 3];
            int x1 = dp[(3 + 1 - mod) % 3];
            int x2 = dp[(3 + 2 - mod) % 3];
            if (x0 != 0 || mod == 0)
                dp[0] = Math.max(dp[0], x0 + x);
            if (x1 != 0 || mod == 1)
                dp[1] = Math.max(dp[1], x1 + x);
            if (x2 != 0 || mod == 2)
                dp[2] = Math.max(dp[2], x2 + x);
        }
        return dp[0];
    }
}
