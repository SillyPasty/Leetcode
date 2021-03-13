package slidingwindow;


public class Ex992_SubarraysWithKDiffInt {
    public static void main(String args[]) {
        Ex992Solution sol = new Ex992Solution();
        int[] A = {1, 2, 1, 2, 3};
        int K = 2;
        System.out.println(sol.subarraysWithKDistinct(A, K));
    }
}

class Ex992Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int result = 0;
        int prefix = 0, l = 0, count = 0;
        int[] map = new int[A.length + 1];
        for (int r = 0; r < A.length; r++) {
            if (map[A[r]]++ == 0) {
                count++;
            }
            if (count > K) {
                map[A[l]]--;
                l++;
                prefix = 0;
                count--;
            }
            while (map[A[l]] > 1) {
                map[A[l]]--;
                l++;
                prefix++;
            }
            if (count == K)
                result += prefix + 1;
        }
        return result;
    }
}