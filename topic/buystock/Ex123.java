package topic.buystock;

public class Ex123 {
    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(new Ex123().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int h1 = Integer.MIN_VALUE, h2 = Integer.MIN_VALUE;
        int r1 = 0, r2 = 0;
        for (int i : prices) {
            r2 = Math.max(r2, h2 + i);
            h2 = Math.max(h2, r1 - i);
            r1 = Math.max(r1, h1 + i);
            h1 = Math.max(h1, -i);
        }
        return r2;
    }

}