package twopointers;

public class Ex713 {
    public static void main (String[] args) {
        int[] nums = {100, 5, 2, 6};
        int k = 100;
        Ex713Solution sol = new Ex713Solution();
        System.out.println(sol.numSubarrayProductLessThanK(nums, k));
    }
}
// EZ
class Ex713Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0, curProduct = 1;
        int lp = 0, rp;
        for (rp = 0; rp < nums.length; rp++) {
            curProduct *= nums[rp];
            while (curProduct >= k && lp <= rp)
                curProduct /= nums[lp++];
            if (curProduct < k)
                result += (rp - lp + 1);   
        }
        return result;
    }
}