package dp;

public class Ex32 {
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(new Ex32().longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        final int len = s.length();
        int[] longest = new int[len];
        int result = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')')
                if (s.charAt(i - 1) == '(')
                    longest[i] = (i - 2) > 0 ? longest[i - 2] + 2 : 2;
                else if (i-longest[i-1]-1 >= 0 && s.charAt(i - longest[i - 1] - 1) == '(')
                    longest[i] = longest[i - 1] + 2 + ((i - longest[i - 1] - 2) > 0 ? longest[i - longest[i - 1] - 2] : 0);
            result = Math.max(result, longest[i]);
        }
        return result;
    }
}
