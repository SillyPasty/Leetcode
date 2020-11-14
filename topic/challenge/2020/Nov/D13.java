import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class D13 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // ArrayList<Integer> exec = new ArrayList<>();
        // for (int i : arr2) {
        //     map.put(i, 0);
        // }
        // for (int i : arr1) {
        //     if (map.containsKey(i)) {
        //         map.put(i, map.get(i) + 1);
        //     } else {
        //         exec.add(i);
        //     }
        // }
        // exec.sort(Comparator.naturalOrder());
        // int[] res = new int[arr1.length];
        // int idx = 0;
        // for (int i : arr2) {
        //     for (int j = 0; j < map.get(i); j++) {
        //         res[idx++] = i;
        //     }
        // }
        // for (int i : exec) {
        //     res[idx++] = i;
        // }
        return count(arr1, arr2);
    }
    public int[] count(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        int[] res = new int[arr1.length];
        int idx = 0;
        for (int i : arr1)
            count[i]++;
        for (int i : arr2)
            while (count[i]-- > 0)
                res[idx++] = i;
        for (int i = 0; i < 1001; i++)
            while (count[i]-- > 0)
                res[idx++] = i;
        return res;
    }
}
