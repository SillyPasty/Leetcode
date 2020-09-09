package topic.buystock;

public class Ex122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int profit = 0, curMin = prices[0];
        for (int i : prices) {
            if (i > curMin) {
                profit += (i - curMin);
                curMin = i;
            }  
            curMin = Math.min(curMin, i);
        }
        return profit;
    }
}