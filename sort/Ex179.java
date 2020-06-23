package sort;

import java.util.Arrays;

public class Ex179 {
    public static void main (String[] args) {
        int[] input = {12, 121};
        Ex179 sol = new Ex179();
        System.out.println(sol.largestNumber(input));
    }

    public String largestNumber(int[] nums) {
        // When there are only two conditions, try to compare then directly.
        String[] numsList = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            numsList[i] = Integer.toString(nums[i]);
        Arrays.sort(numsList, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        String result = "";
        for (int i = 0; i < numsList.length; i++)
            result += numsList[i];
        return result.charAt(0) == '0' ? "0" : result;
    }
}