package slidingwindow;

import java.util.Deque;
import java.util.ArrayDeque;

public class Ex239_SlidingWindowMaximum {
    public static void main(String args[]) {
        Ex239Solution sol = new Ex239Solution();
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 4;
        int res[] = sol.maxSlidingWindow(nums, k);
        for (int x : res)
            System.out.println(x);
    }
}

class Ex239Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int result[] = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < nums.length; i++) {
            while (queue.isEmpty() != true && queue.getLast() < nums[i])
                queue.removeLast();
            queue.addLast(nums[i]);
            if (i >= k - 1) {
                result[i - k + 1] = queue.getFirst(); 
                if(nums[i - k + 1] == queue.getFirst())
                    queue.removeFirst();
            }
        }
        return result;
    }
}