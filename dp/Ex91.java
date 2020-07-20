package dp;

public class Ex91 {
    public static void main (String[] args) {
        String s = "12";
        System.out.println(new Ex91().numDecodings(s));
    }
    public int numDecodings(String s) {
        final int LENGTH = s.length();
        int[] dp = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            char c = s.charAt(i);
            if (i == 0) 
                if (c == '0')
                    return 0;
                else
                    dp[i] = 1;
            else {
                char prev_c = s.charAt(i - 1);
                if (c == '0' && prev_c == '0')
                    return 0;

                int x = (int)(prev_c - '0') * 10 + (int)(c - '0');
                if (10 <= x && x <= 26)
                    dp[i] += (i >= 2 ? dp[i - 2] : 1);

                if (c != '0')
                    dp[i] += (dp[i - 1]);
            }
        }
        return dp[LENGTH - 1];
    }
}