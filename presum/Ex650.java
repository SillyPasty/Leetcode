package presum;

import java.util.HashMap;
import java.util.Map;

public class Ex650 {
    public static void main (String[] args) {
        Ex560Solution sol = new Ex560Solution();
        
    }
}

class Ex560Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
            sum += i;
            if (map.containsKey(sum - k))
                result += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }   
}