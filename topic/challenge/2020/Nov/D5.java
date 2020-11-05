import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D5 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        int[] dist = new int[len];
        Arrays.fill(dist, -1);
        int idx = -1;
        ArrayList<Integer>[] arrs = new ArrayList[len];
        for (int i = 0; i < len; i++)
            arrs[i] = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            if (endWord.equals(wordList.get(i)))
                idx = i;
            for (int j = i + 1; j < len; j++) {
                int dis = calDistance(wordList.get(i), wordList.get(j));
                if (dis != 1)
                    continue;
                arrs[j].add(i);
                arrs[i].add(j);
            }
        }
        if (idx == -1)
            return 0;
        dist[idx] = 0;
        bfs(arrs, dist, idx);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int distan = calDistance(beginWord, wordList.get(i));
            if (dist[i] == -1)
                continue;
            if (distan == 0)
                res = Math.min(res, dist[i] + 1);
            if (distan == 1)
                res = Math.min(res, dist[i] + 2);
        }
        if (res == Integer.MAX_VALUE)
            return 0;
        return res;
    }
    public int calDistance(String a, String b) {
        int res = 0;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                res++;
        return res;
    }
    public void bfs(ArrayList<Integer>[] conns, int[] dist, int head) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            int cur = queue.pop();
            for (int i : conns[cur]) {
                if (i != head && dist[i] == -1) {
                    dist[i] = dist[cur] + 1;
                    queue.offer(i);
                }
            }
        }
    }
}
