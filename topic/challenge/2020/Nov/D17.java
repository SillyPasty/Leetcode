class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        ArrayList<int[]> result = new ArrayList<>();
        int[][] isVisited = new int[R][C];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r0, c0});
        isVisited[r0][c0] = 1;
        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            result.add(curPoint);
            int r = curPoint[0];
            int c = curPoint[1];
            if (r - 1 >= 0 && isVisited[r - 1][c] == 0) {
                isVisited[r - 1][c] = 1;
                queue.add(new int[] {r - 1, c});
            }
            if (c - 1 >= 0 && isVisited[r][c - 1] == 0) {
                isVisited[r][c - 1] = 1;
                queue.add(new int[] {r, c - 1});
            }
            if (r + 1 < R && isVisited[r + 1][c] == 0) {
                isVisited[r + 1][c] = 1;
                queue.add(new int[] {r + 1, c});
            }
            if (c + 1 < C && isVisited[r][c + 1] == 0) {
                isVisited[r][c + 1] = 1;
                queue.add(new int[] {r, c + 1});
            }
                
        }
        int[][] ret = new int[R * C][2];
        for (int i = 0; i < result.size(); i++) {
            ret[i][0] = result.get(i)[0];
            ret[i][1] = result.get(i)[1];
        }
        return ret;
    }
}