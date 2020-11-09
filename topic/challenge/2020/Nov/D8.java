import java.util.PriorityQueue;

public class D8 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> priQ = new PriorityQueue<int[]>(11, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { 
                if ((o1[0] * o1[0] + o1[1] * o1[1]) < (o2[0] * o2[0] + o2[1] * o2[1])) 
                    return 1;
                return -1;      
            }
        });
        for (int[] point : points) {
            if (priQ.size() < K) {
                priQ.offer(point);
                continue;
            }
            int[] top = priQ.peek();
            double len1 = top[0] * top[0] + top[1] * top[1];
            double len2 = point[0] * point[0] + point[1] * point[1];
            if (len1 > len2) {
                priQ.poll();
                priQ.offer(point);
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] top = priQ.poll();
            res[i][0] = top[0];
            res[i][1] = top[1];
        }
        return res;
    }
}
