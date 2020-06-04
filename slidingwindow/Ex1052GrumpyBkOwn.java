package slidingwindow;

public class Ex1052GrumpyBkOwn {
    public static void main (String args[]) {
        Ex1052Solution sol = new Ex1052Solution();
        int[] customers = {10, 1, 7};
        int[] grumpy = {0, 0, 0};
        int X = 2;
        System.out.println(sol.maxSatisfied(customers, grumpy, X));
    }
}

class Ex1052Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int oneCnt = 0, zeroCnt = 0, startIdx = 0, maxCnt = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (i >= X && grumpy[startIdx++] == 1) 
                zeroCnt -= customers[startIdx - 1];
            if (grumpy[i] == 1)
                zeroCnt += customers[i];
            else
                oneCnt += customers[i];
            maxCnt = Math.max(maxCnt, zeroCnt);
        }
        return maxCnt + oneCnt;
    }
}