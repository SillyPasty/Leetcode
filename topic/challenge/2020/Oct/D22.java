import java.util.ArrayList;
import java.util.List;

public class D22 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<Integer>();
        int[] cnt = new int[26];
        for (int i = 0; i < S.length(); i++)
            cnt[S.charAt(i) - 'a'] = i;
        int lp = -1, rp = 0;
        for (int i = 0; i < S.length(); i++) {
            rp = Math.max(rp, cnt[S.charAt(i) - 'a']);
            if (rp == i) {
                res.add(rp - lp);
                lp = rp;
                rp = 0;
            }
        }
        return res;
    }
}
