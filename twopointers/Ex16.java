package twopointers;

import java.util.Arrays;

public class Ex16 {
    public static void main (String[] args) {
        Ex16Solution sol = new Ex16Solution();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(sol.threeSumClosest(nums, target));
    }
}

class Ex16Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0, diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lp = i + 1, rp = nums.length - 1;
            while (lp < rp) {
                int curSum = nums[lp] + nums[rp] + nums[i];
                int curDiff = Math.abs(curSum - target);
                if (curDiff == 0) return target;
                else if (curSum < target) lp++;
                else rp--;
                if (curDiff < diff) {
                    diff = curDiff;
                    result = curSum;
                }
            }
        }
        return result;
    }
}