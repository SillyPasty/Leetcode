import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class lc310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        class Node {
            HashMap<Integer, Boolean> hashMap = new HashMap<>();
            int n;
            int degree;
            public Node(int n) {
                this.n = n;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            Node n0 = map.getOrDefault(edges[i][0], null);
            if (n0 == null) {
                n0 = new Node(edges[i][0]);
                map.put(edges[i][0], n0);
            }
            
            Node n1 = map.getOrDefault(edges[i][1], null);
            if (n1 == null) {
                n1 = new Node(edges[i][1]);
                map.put(edges[i][1], n1);
            }

            n0.hashMap.put(edges[i][1], true);
            n0.degree++;
            
            n1.hashMap.put(edges[i][0], true);
            n1.degree++;
        }

        Queue<Node> queue = new LinkedList<Node>();
        for (int i = 0; i < n; i++)
            if (map.get(i).degree == 1)
                queue.add(map.get(i));
        while (n > 2) {
            Queue<Node> tmp = new LinkedList<Node>();
            while (queue.isEmpty() == false) {
                Node no = queue.poll();
                map.remove(no.n);
                Node nn = null;
                for (Integer k : no.hashMap.keySet())
                    nn = map.get(k);
                nn.hashMap.remove(no.n);
                nn.degree--;
                if (nn.degree == 1)
                    tmp.add(nn);
                n--;
            }
            queue = tmp;
        }
        for (Integer k : map.keySet())
            res.add(k);
        return res;
    }
}
