package twopointers;
// three sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex15 {
    public static void main (String[] args) {
        Ex15Solution sol = new Ex15Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(sol.threeSum(nums));
    }
    
}

class Ex15Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    if ((nums[i] + nums[lo] + nums[hi]) == 0) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if ((nums[i] + nums[lo] + nums[hi]) < 0)
                        lo++;
                    else 
                        hi--;
                } 
            }
            
        }
        return result;
    }
}