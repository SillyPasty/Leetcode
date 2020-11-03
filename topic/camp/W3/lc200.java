class Solution {
    public int numIslands(char[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int res = 0;
        boolean[][] isVisited = new boolean[x][y];
        for (int i = 0; i < x; i ++)
            for (int j = 0; j < y; j++) {
                if (isVisited[i][j] == false && grid[i][j] == '1') {
                    res++;
                    dfs(i, j, isVisited, grid);
                } 
            }
        return res;
    }
    public void dfs(int x, int y, boolean[][] isVisited, char[][] grid) {
        if (x < 0 || x >= grid.length)
            return;
        if (y < 0 || y >= grid[0].length)
            return;
        if (isVisited[x][y] == true || grid[x][y] == '0')
            return;
        isVisited[x][y] = true;
        dfs(x - 1, y, isVisited, grid);
        dfs(x + 1, y, isVisited, grid);
        dfs(x, y - 1, isVisited, grid);
        dfs(x, y + 1, isVisited, grid);
    }
}