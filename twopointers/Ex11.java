package twopointers;

public class Ex11 {
    public static void main (String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Ex11Solution sol = new Ex11Solution();
        System.out.println(sol.maxArea(input));
    }
}

class Ex11Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int leftP = 0, rightP = height.length - 1;
        while (leftP != rightP) {
            result = Math.max(result, (rightP - leftP) * Math.min(height[leftP], height[rightP]));
            if (height[leftP] > height[rightP])
                rightP--;
            else
                leftP++;
        }
        return result;
    }
}