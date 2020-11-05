public class lc300 {
    public int lengthOfLIS(int[] nums) {
        // return on2(nums);
        return nlogn(nums);
    }

    public int on2(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        int res = dp[0];
        for (int i = 0; i < len; i++)
            res = Math.max(dp[i], res);
        return res;
    }
    public int nlogn(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (dp[m] < num) i = m + 1;
                else j = m;
            }
            dp[i] = num;
            if (res == j) res++;
        }
        return res;
    }
}
