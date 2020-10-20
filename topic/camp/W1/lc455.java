import java.util.Arrays;

public class lc455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, idx = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (idx < 0)
                return res;
            if (g[i] <= s[idx]) {
                idx--;
                res++;
            }
        }
        return res;
    }
}
