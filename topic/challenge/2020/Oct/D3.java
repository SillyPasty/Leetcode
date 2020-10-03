import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Boolean> map = new HashMap<>();
        Map<Integer, Integer> store = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            if (k == 0) {
                if (map.getOrDefault(i, false) && store.getOrDefault(i, 0) != 1) {
                    res++;
                    store.put(i, 1);
                }
                    
            } else {
                if (map.getOrDefault(i + k, false)) {
                    if (store.getOrDefault(i, 0) == 0)
                        store.put(i, 1);
                    else
                        res--;
                    res++;
                }

                if (map.getOrDefault(i - k, false)) {
                    if (store.getOrDefault(i - k, 0) == 0)
                        store.put(i - k, -1);
                    else
                        res--;
                    res++;
                }
            }
            map.put(i, true);
        }
        return res;
    }
}
