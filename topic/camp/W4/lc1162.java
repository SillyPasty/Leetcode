import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lc1162 {
    // 多源bfs
    public int maxDistance(int[][] grid) {
        int N = grid.length;
        int res = 0;
        int isVisited[][] = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(isVisited[i], -1);
        Queue<int[]> nodeQueue = new LinkedList<int[]>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    nodeQueue.offer(new int[] {i, j});
                    isVisited[i][j] = 0;
                }
            }
        }
        if (nodeQueue.size() == 0 || nodeQueue.size() == (N * N)) {
            return -1;
        }
        while (!nodeQueue.isEmpty()) {
            int[] curNode = nodeQueue.poll();
            int x = curNode[0];
            int y = curNode[1];
            int curDist = isVisited[x][y];
            res = Math.max(curDist, res);
            if (x + 1 < N && isVisited[x+1][y] == -1) {
                isVisited[x+1][y] = curDist + 1;
                nodeQueue.offer(new int[] {(x+1), y});
            }
            if (x - 1 >= 0 && isVisited[x-1][y] == -1) {
                isVisited[x-1][y] = curDist + 1;
                nodeQueue.offer(new int[] {(x-1), y});
            }
            if (y + 1 < N && isVisited[x][y+1] == -1) {
                isVisited[x][y+1] = curDist + 1;
                nodeQueue.offer(new int[] {x,(y+1)});
            }
            if (y - 1 >= 0 && isVisited[x][y-1] == -1) {
                isVisited[x][y-1] = curDist + 1;
                nodeQueue.offer(new int[] {x,(y-1)});
            }
        }
        return res;
    }
}
