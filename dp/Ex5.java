package dp;

public class Ex5 {
    public static void main (String[] args) {
        String s = "a";
        String s2 = "babad";
        System.out.println(new Ex5().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        final int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String res = "";
        for (int i = length - 1; i >= 0; i--)
            for (int j = i; j < length; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]));
                if (j - i >= res.length() && dp[i][j])
                    res = s.substring(i, j + 1);
            }
        return res;
    }
}