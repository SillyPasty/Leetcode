package topic.buystock;

public class Ex121 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int profit = 0, min = prices[0];
        for (int i : prices) {
            profit = Math.max(profit, i - min);
            min = Math.min(i, min);
        }
        return profit;
    }
}
