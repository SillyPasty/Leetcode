package twopointers;

public class Ex42 {
    public static void main (String[] args) {
        Ex42Solution sol = new Ex42Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height1 = {1, 0, 1};
        System.out.println(sol.trap(height1));
    }
}

class Ex42Solution {
    // one path solution
    public int trap(int[] height) {
        int result = 0;
        final int length = height.length;
        int lp = 0, rp = length - 1, maxL = 0, maxR = 0;
        while (lp <= rp) {
            if (height[lp] <= height[rp]) {
                if (height[lp] >= maxL) maxL = height[lp];
                else result += maxL - height[lp];
                lp++;
            } else {
                if (height[rp] >= maxR) maxR = height[rp];
                else result += maxR - height[rp];
                rp--;
            }
        }
        return result;
    }
}