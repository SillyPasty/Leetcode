package dp;

public class Ex63 {
    public static void main (String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new Ex63().uniquePathsWithObstacles(obstacleGrid));
    }   
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < obstacleGrid[0].length; i++)
            dp[0][i] = obstacleGrid[0][i] == 0 ? dp[0][i - 1] : 0;
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (j == 0)
                    dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] : 0;
                else
                    dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}