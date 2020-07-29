package dp;

public class Ex115 {
    public static void main (String[] args) {
        String s = "abg";
        String t = "";
        System.out.println(new Ex115().numDistinct(s, t));
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++)
            dp[0][i] = 1;
        for (int i = 0; i < t.length(); i++)
            for (int j = i; j < s.length(); j++){
                if (t.charAt(i) == s.charAt(j))
                    dp[i+1][j+1] += dp[i][j];
                dp[i+1][j+1] += dp[i+1][j];
            }
        return dp[t.length()][s.length()];
    }
}