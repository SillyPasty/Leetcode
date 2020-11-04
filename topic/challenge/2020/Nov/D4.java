import java.util.ArrayList;

public class D4 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        boolean flag = false;
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] interval: intervals) {
            if (interval[1] < left)
                res.add(interval);
            else if (interval[0] > right) {
                if (!flag) {
                    flag = true;
                    res.add(new int[]{left, right});
                }
                res.add(interval);
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }
        if (!flag)
            res.add(new int[]{left, right});
        int[][] ret = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++)
            ret[i] = res.get(i);
        return ret;
    }
}
