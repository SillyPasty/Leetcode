package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex18 {
    public static void main (String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        Ex18Solution sol = new Ex18Solution();
        System.out.println("wtf");
        System.out.println(sol.fourSum(nums, target));
    }
}

class Ex18Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i != 0 && nums[i] != nums[i - 1]))
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || (j != i + 1 && nums[j] != nums[j - 1])) {
                        int lp = j + 1, rp = nums.length - 1;
                        while (lp < rp) {
                            int curSum = nums[i] + nums[j] + nums[lp] + nums[rp];
                            if (curSum == target) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[lp], nums[rp]));
                                while (lp < rp && nums[lp] == nums[lp + 1]) lp++;
                                while (lp < rp && nums[rp] == nums[rp - 1]) rp--;
                                lp++; rp--;
                            } else if (curSum > target) {
                                rp--;
                            } else {
                                lp++;
                            }   
                        }
                        
                    }
                }
        }
        return result;
    }
}