public class example {
    // 1, 3, 5 coins min
    public static void main (String args[]) {
        int a[] = {1, 3, 5};
        int dp[] = new int[12];
        for (int i = 0; i < 12; i++)
            dp[i] = 65536;
        dp[0] = 0;
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < 3; j++) {
                if (i >= a[j] && dp[i] > (dp[i - a[j]] + 1))
                    dp[i] = dp[i - a[j]] + 1;
            }
        for (int x : dp)
            System.out.println(x);
    }
}