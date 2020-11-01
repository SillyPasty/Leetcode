import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class D1 {
    HashMap<String, Boolean> map = new HashMap<>();
    ArrayList<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict)
            map.put(word, true);
        int len = s.length();
        Deque<String> path = new ArrayDeque<>();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int right = 1; right <= len; right++) {
            for (int left = right - 1; left >= 0; left--) {
                if (map.getOrDefault(s.substring(left, right), false) && dp[left]) {
                    dp[right] = true;
                    break;
                }
            }
        }
        if (dp[len]) {
            tra(s.length(), s, path);
        }
        return res;
    }

    public void tra(int l, String origS, Deque<String> path) {
        if (l == 0) {
            res.add(String.join(" ", path));
            return;
        }
        for (int i = l - 1; i >= 0; i--) {
            String tmp = origS.substring(i, l);
            if (map.getOrDefault(tmp, false) && dp[i]) {
                path.addFirst(tmp);
                tra(i, origS, path);
                path.removeFirst();
            }
        }
    }
}
