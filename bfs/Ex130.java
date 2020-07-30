package bfs;

public class Ex130 {
    class Solution {
        int X, Y;
        int[][] isVisited;

        public void solve(char[][] board) {
            this.X = board.length;
            if (this.X == 0)
                return;
            this.Y = board[0].length;
            if (this.Y == 0)
                return;
            this.isVisited = new int[this.X][this.Y];
            for (int i = 0; i < X; i++) {
                bfs(i, 0, board);
                bfs(i, this.Y-1, board);
            }
            for (int j = 0; j < Y; j++) {
                bfs(0, j, board);
                bfs(this.X-1, j, board);
            }
            for (int i = 0; i < this.X; i++)
                for (int j = 0; j < this.Y; j++)
                    if (isVisited[i][j] != 1)
                        board[i][j] = 'X';
        }

        private void bfs(int x, int y, char[][] board) {
            if (x < 0 || y < 0 || x >= this.X || y >= this.Y)
                return;
            if (board[x][y] == 'X')
                return;
            if (this.isVisited[x][y] == 1)
                return;
            this.isVisited[x][y] = 1;
            bfs(x, y + 1, board);
            bfs(x, y - 1, board);
            bfs(x + 1, y, board);
            bfs(x - 1, y, board);
        }
    }
}