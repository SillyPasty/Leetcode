package sort;

public class qSort {
    public static void main(String[] args) {
        int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        int[] nums1 = {5, 2, 6, 1};
        new qSort().sort(nums, 0, nums.length - 1);
        for (int num: nums)
            System.out.println(num);
    }
    public void sort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int k = part(array, start, end);
        sort(array, start, k - 1);
        sort(array, k + 1, end);
    }

    private int part(int[] array, int start, int end) {
        int flag = array[start];
        swap(array, start, end);
        int left = start, right = end - 1;
        while (true) {
            while (array[left] < flag)
                left++;
            while (right >= start && array[right] >= flag)
                right--;
            if (left >= right)
                break;
            swap(array, left, right);
        }
        swap(array, left, end);
        return left;
    }

    private void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}