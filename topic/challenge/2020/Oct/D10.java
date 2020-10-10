import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return (o1[0] > o2[0]) ? 1 : -1;
                return (o1[1] > o2[1]) ? 1 : -1;
            }
        });
        if (points.length == 0)
            return 0;
        int curMin = points[0][1], result = 1;
        for (int i = 0; i < points.length; i++) {
            if (curMin < points[i][0]) {
                result++;
                curMin = points[i][1];
            }
            curMin = Math.min(points[i][1], curMin);
        }
        return result;
    }
}