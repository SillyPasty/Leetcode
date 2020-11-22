public class Q3 {
    public static void main (String[] args) {
        int[] nums = {2, 1, 6, 4};
        new Q3().waysToMakeFair(nums);
    }
    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][4];
        for (int i = 1; i < len; i++) {
            int r = len - 1 - i;
            for (int j = 0; j < 2; j++) {
                dp[i][j] += dp[i - 1][j];
                dp[r][3 - j] += dp[r + 1][3 - j];
            }
            if (i % 2 == 1) {
                dp[i][1] += nums[i - 1];
            } else {
                dp[i][0] += nums[i - 1];
            }
            
            if (r % 2 == 1) {
                dp[r][3] += nums[r + 1];
            } else {
                dp[r][2] += nums[r + 1];
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i][0] + dp[i][3] == dp[i][1] + dp[i][2])
                res++;
        }
        return res;
    }
}
