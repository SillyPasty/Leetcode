package sort;

import java.util.LinkedList;
import java.util.Arrays;

public class Ex56 {
    public static void main(String[] args) {
        Ex56Solution sol = new Ex56Solution();
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] result = sol.merge(intervals);
        for (int[] x : result) {
            for (int y : x)
                System.out.print("" + y + ",");
            System.out.println();
        }
    }
}

class Ex56Solution {
    // Good use of max()
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> res = new LinkedList<int[]>();
        for (int[] interval : intervals) {
            if (res.isEmpty() || res.getLast()[1] < interval[0])
                res.add(interval);
            else
                res.getLast()[1] = Math.max(interval[1], res.getLast()[1]);
        }
        return res.toArray(new int[res.size()][]);
    }
}