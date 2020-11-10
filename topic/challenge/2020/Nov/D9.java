public class D9 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return;
        int flag = nums[len - 1], idx = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] >= flag) {
                flag = nums[i];
            }
            else {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            for (int i = len - 1; i >= idx; i--) {
                if (nums[i] > nums[idx]) {
                    int tmp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }
        }
        int l = idx + 1, r = len - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
        return;
    }
}
