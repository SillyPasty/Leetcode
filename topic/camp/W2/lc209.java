public class lc209 {
    public int minSubArrayLen(int s, int[] nums) {
        int lp = 0, rp = 0;
        int res = -1, cur = 0;
        while (rp < nums.length) {
            if (cur >= s) {
                if (res == -1)
                    res = rp - lp;
                res = Math.min(rp - lp, res);
                cur -= nums[lp];
                lp++;
            } else {
                cur += nums[rp];
                rp++;
            }
        }
        while (cur >= s && lp < nums.length) {
            if (res == -1)
                res = rp - lp;
            res = Math.min(rp - lp, res);
            cur -= nums[lp];
            lp++;
        }
        if (res == -1)
            return 0;
        return res;
    }
}
