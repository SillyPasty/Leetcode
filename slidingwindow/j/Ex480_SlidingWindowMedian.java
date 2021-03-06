package slidingwindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Ex480_SlidingWindowMedian {
    public static void main (String args[]) {
        Ex480Solution sol = new Ex480Solution();
        int nums[] = {-2147483648,-2147483648,2147483647,-2147483648};
        int k = 3;
        double result[] = sol.medianSlidingWindow(nums, k);
        for (double x: result) {
            System.out.print(x + " ");
        }
    }
}

class Ex480Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double result[] = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        ArrayList<Integer> median = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                
                result[i - k] = getMed(median);
                remove(median, minHeap, maxHeap, nums[i - k]);
            }   
            add(median, minHeap, maxHeap, nums[i]);
        }

        result[nums.length - k] = getMed(median);
        return result;
    }

    private void add(ArrayList<Integer> median, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int val) {
        if (!minHeap.isEmpty())
            if (val > minHeap.peek()) {
                int tmp = val;
                val = minHeap.poll();
                minHeap.add(tmp);
            } else if (val < maxHeap.peek()) {
                int tmp = val;
                val = maxHeap.poll();
                maxHeap.add(tmp);
            }

        if (median.size() == 1 || median.size() == 0) {
            median.add(val);
            return;
        }

        median.add(val);
        median.sort(new Comparator<Integer>() {
            public int compare (Integer a, Integer b) {
                return a.compareTo(b);
            }
        });
        System.out.println();
        maxHeap.add(median.get(0));
        minHeap.add(median.get(2));
        median.remove(2);
        median.remove(0);
    }

    private double getMed(ArrayList<Integer> median) {
        if (median.size() == 1) {
            return median.get(0);
        }
        return ((double)median.get(0) + median.get(1)) / 2;
    }

    private void remove(ArrayList<Integer> median, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int val) {
        if (median.contains(val)) {
            median.remove(median.indexOf(val));
            return;
        }
        median.sort(new Comparator<Integer>() {
            public int compare (Integer a, Integer b) {
                return a.compareTo(b);
            }
        });
        if (val < median.get(0)) {
            maxHeap.remove(val);
            maxHeap.add(median.get(0));
            median.remove(0);
        } else {
            minHeap.remove(val);
            minHeap.add(median.get(median.size() - 1));
            median.remove(median.get(median.size() - 1));
        }
    }
}