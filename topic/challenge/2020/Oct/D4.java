import java.util.Arrays;
import java.util.Comparator;


public class D4 {
    public static void main (String[] args) {
        int[][] intervals = {{1, 2}, {1, 4}, {3, 4}};
        new D4().removeCoveredIntervals(intervals);
    }
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if (o1[0] - o2[0] != 0)
                    return o1[0] - o2[0];
                return o2[1] - o1[1];
            }
        });
        int res = 1, cur = intervals[0][1];
        for (int[] x : intervals) {
            if (cur <= x[0]) {
                cur = x[1];
            } else if (cur < x[1]) {
                cur = x[1];
            } else {
                res--;
            }
            res++;
        }
        System.out.println(res);
        return res;
    }
}
