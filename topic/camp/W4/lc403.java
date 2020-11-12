package topic.camp.W4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc403 {
    // dp
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        int n = stones.length;
        if (n == 1) {
            return true;
        }
        if (stones[1] != 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        int last = stones[n - 1];
        HashSet<Integer> hs = new HashSet();
        for (int i = 0; i < n; i++) {
            if (i > 3 && stones[i] > stones[i - 1] + i) {
                return false;
            } // The two stones are too far away.
            hs.add(stones[i]);
        }
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int j : map.get(stones[i])) {
                for (int step = j - 1; step <= j + 1; step++) {
                    if (step > 0 && map.containsKey(step + stones[i])) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        if (map.get(stones[stones.length - 1]).size() != 0)
            return true;
        return false;
    }
}
