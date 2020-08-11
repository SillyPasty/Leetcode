package dp;

public class Ex213 {
    public int rob(int[] nums) {
        final int LENGTH = nums.length;
        if (LENGTH == 0)
            return 0;
        if (LENGTH == 1)
            return nums[0];
        int max = -1;
        int[] dp = new int[LENGTH + 1];
        dp[1] = nums[0];
        for (int i = 1; i < LENGTH; i++)
            if (i == LENGTH - 1)
                dp[i + 1] = dp[i];
            else
                dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        max = Math.max(dp[LENGTH], max);
        
        dp[1] = 0;
        for (int i = 1; i < LENGTH; i++)
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        return Math.max(max, dp[LENGTH]);
    }
}