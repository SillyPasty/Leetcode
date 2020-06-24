package sort;

import java.util.Arrays;

public class Ex164 {
    public static void main(String[] args) {
        int[] nums = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        System.out.println(new Ex164().maximumGap(nums));
    }

    public int maximumGap(int[] nums) {
        // Why use ceiling?
        if (nums == null || nums.length < 2)
            return 0;
        final int length = nums.length;
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] maxBucket = new int[length - 1];
        int[] minBucket = new int[length - 1];
        int gap = (int) Math.ceil((double) (max - min) / (length - 1));
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        // put the numbers into the bucket
        for (int num : nums) {
            if (num == max || num == min)
                continue;
            int idx = (num - min) / gap;
            maxBucket[idx] = Math.max(maxBucket[idx], num);
            minBucket[idx] = Math.min(minBucket[idx], num);
        }

        int maxGap = -1;
        int previous = min;
        // find the gap
        for (int i = 0; i < length - 1; i++) {
            if (maxBucket[i] == Integer.MIN_VALUE && minBucket[i] == Integer.MAX_VALUE)
                continue;
            maxGap = Math.max(maxGap, minBucket[i] - previous);
            previous = maxBucket[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }

    public int onlineSolution(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        // get the max and min value of the array
        int min = num[0];
        int max = num[0];
        for (int i : num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));
        int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
        int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int i : num) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap; // index of the right position in the buckets
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;
    }
}