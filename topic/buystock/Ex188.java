package topic.buystock;

public class Ex188 {
    public int maxProfit(int k, int[] prices) {
        final int LENGTH = prices.length;
        if (LENGTH == 0)
            return 0;
        if (k >= LENGTH / 2)
            return quickProfit(prices);
        int[][] dp = new int[k + 1][LENGTH];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < LENGTH; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(dp[i - 1][j - 1] - prices[j], tmpMax);
            }
        }
        return dp[k][LENGTH - 1];
    }
    private int quickProfit(int[] prices) {
        final int LENGTH = prices.length;
        int profit = 0;
        for (int i = 1; i < LENGTH; i++) 
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        return profit;
    }
}