class Ex221 {
    public int maximalSquare(char[][] matrix) {
        final int XLENGTH = matrix.length;
        if (XLENGTH == 0)
            return 0;
        final int YLENGTH = matrix[0].length;
        if (YLENGTH == 0)
            return 0;
        int max = 0;
        int[][] dp = new int[XLENGTH + 1][YLENGTH + 1];
        for (int i = 1; i <= XLENGTH; i++) {
            for (int j = 1; j <= YLENGTH; j++) {
                if (matrix[i - 1][j - 1] == '0')
                    dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}