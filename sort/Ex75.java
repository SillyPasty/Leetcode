package sort;

public class Ex75 {
    public void sortColors(int[] nums) {
        int[] cnts = new int[3];
        for (int num : nums)
            cnts[num]++;
        int idx = 0;
        for (int i = 0; i < cnts.length; i++)
            for (int j = 0; j < cnts[i]; j++)
                nums[idx++] = i;                
    }
}