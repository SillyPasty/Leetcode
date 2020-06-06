package presum;

import java.util.Map;
import java.util.HashMap;

public class Ex1074 {
    public static void main (String[] args) {
        int[][] matrix = {{0,1,0},{1,1,1},{0,1,0}};
        int target = 0;
        Ex1074Solution sol = new Ex1074Solution();
        System.out.println(sol.numSubmatrixSumTarget(matrix, target));
    }
}

class Ex1074Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        for (int i = 1; i < matrix.length; i++) 
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] += matrix[i - 1][j];
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                counter.clear();
                counter.put(0, 1);
                int sums = 0;
                for (int k = 0; k < matrix[j].length; k++){
                    sums += matrix[j][k] - (i > 0 ? matrix[i - 1][k] : 0);
                    res += counter.getOrDefault(sums - target, 0);
                    counter.put(sums, counter.getOrDefault(sums, 0) + 1);
                }
            }
        }
        return res;
    }
}