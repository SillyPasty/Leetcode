package dp;

import java.util.Arrays;

public class Ex85 {
    public static void main (String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        char[][] matrix1 = {};
        System.out.println(new Ex85().maximalRectangle(matrix1));
    }
    public int maximalRectangle(char[][] matrix) {
        final int X = matrix.length;
        if (X == 0)
            return 0;
        final int Y = matrix[0].length;
        int[] left = new int[Y];
        int[] right = new int[Y];
        int[] height = new int[Y];
        Arrays.fill(left, 0);
        Arrays.fill(right, Y);
        int max_area = 0;
        for (int i = 0; i < X; i++) {
            int cur_left = 0, cur_right = Y;
            for (int j = 0; j < Y; j++) {
                int right_idx = Y - 1 - j; 
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                    height[j]++;
                } else {
                    left[j] = 0; cur_left = j + 1;
                    height[j] = 0;
                }

                if (matrix[i][right_idx] == '1') {
                    right[right_idx] = Math.min(right[right_idx], cur_right);
                } else {
                    right[right_idx] = Y; cur_right = right_idx;
                }
            }
            for (int j = 0; j < Y; j++)
                max_area = Math.max(max_area, (right[j] - left[j]) * height[j]);
        }
        return max_area;
    }
}