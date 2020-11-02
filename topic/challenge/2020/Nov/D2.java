import java.util.ArrayList;
import java.util.HashMap;

public class D2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int num1 : nums1)
            map.put(num1, true);
        for (int num2: nums2)
            if (map.getOrDefault(num2, false)) {
                res.add(num2);
                map.put(num2, false);
            }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ret[i] = res.get(i);
        return ret;        
    }
}
