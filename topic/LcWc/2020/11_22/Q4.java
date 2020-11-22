import java.util.Arrays;
import java.util.Comparator;

public class Q4 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, new Comparator<int[]>(){
            public int compare(int[] x1, int[] x2) {
                if (x1[1] - x1[0] != x2[1] - x2[0])
                    return (x1[1] - x1[0]) - (x2[1] - x2[0]);
                else {
                    return x2[1] - x1[1];
                }
            }
        });
        int cur = 0;
        for (int[] task : tasks) {
            int extra = Math.max(0, task[1] - (cur + task[0]));
            cur = cur + extra + task[0];
        }
        return cur;
    }
}
