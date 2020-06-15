package twopointers;

public class Ex80 {
    public static void main (String[] args) {
        int[] nums = {0};
        Ex80Solution sol = new Ex80Solution();
        System.out.println(sol.removeDuplicates(nums));
        for (int x : nums)
            System.out.println(x);
    }
}

class Ex80Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int lp = 1, rp = 1, cnt = 1;
        while (rp < nums.length) {
            if (nums[rp] == nums[rp - 1] && cnt < 2) {
                nums[lp++] = nums[rp++];
                cnt++;
            } else if (nums[rp] == nums[rp - 1] && cnt >= 2) {
                rp++;
                cnt++;
            } else {
                cnt = 1;
                nums[lp++] = nums[rp++];
            }
        }
        return lp;
    }
}