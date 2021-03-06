package slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class Ex995MinNumofKConseBitFlips {
    public static void main(String args[]) {
        Ex995Solution sol = new Ex995Solution();
        int[] A = {0, 0, 0, 1, 0, 1, 1, 0};
        int K = 1;
        System.out.println(sol.minKBitFlips(A, K));
    }
}

class Ex995Solution {
    public int minKBitFlips(int[] A, int K) {
        int result = 0, flipped = 0;
        Queue<Integer> isFlipped = new LinkedList<Integer>();
        // int[] isFlipped = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i >= K)
                flipped ^= isFlipped.poll();
            if (A[i] == flipped) {
                if (i + K > A.length)
                    return -1;
                isFlipped.offer(1);
                flipped ^= 1;
                result++;
            } else {
                isFlipped.offer(0);
            }
        }
        return result;
    }
}