public class D30 {
    int HEIGHT, WIDTH;
    int result = 0;
    int[][] isVisited;
    public int islandPerimeter(int[][] grid) {
        // faster
        int a = grid.length;
        int b = grid[0].length;
        int res = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        res -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }

    public int islandPerimeter(int[][] grid, int x) {
        HEIGHT = grid.length;
        if (HEIGHT == 0)
            return 0;
        WIDTH = grid[0].length;
        isVisited = new int[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++)
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    return result;
                }
        return result;
    }
    public void dfs(int r, int c, int[][] grid) {
        if (isVisited[r][c] == 1)
            return;
        isVisited[r][c] = 1;
        if (r + 1 < HEIGHT && grid[r + 1][c] == 1)
            dfs(r + 1, c, grid);
        else
            result++;
        if (c + 1 < WIDTH && grid[r][c + 1] == 1)
            dfs(r, c + 1, grid);
        else
            result++;

        if (0 <= r - 1 && grid[r - 1][c] == 1)
            dfs(r - 1, c, grid);
        else
            result++;
        if (0 <= c - 1 && grid[r][c - 1] == 1)
            dfs(r, c - 1, grid);
        else
            result++;
    }
}

