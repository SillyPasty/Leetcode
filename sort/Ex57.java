package sort;

import java.util.LinkedList;

public class Ex57 {
    public static void main (String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4, 8};
        int[][] result = new Ex57Solution().insert(intervals, newInterval);
        for (int[] x : result) {
            for (int y : x)
                System.out.print("" + y + ",");
            System.out.println();
        }
    }
}
// Pay attention to the details!
class Ex57Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> res = new LinkedList<int[]>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0])
            res.add(intervals[i++]);
        res.add(newInterval);
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            res.getLast()[0] = Math.min(intervals[i][0], newInterval[0]);
            res.getLast()[1] = Math.max(intervals[i++][1], newInterval[1]);
        }
        while (i < intervals.length)
            res.add(intervals[i++]);
        return res.toArray(new int[res.size()][2]);
    }
}