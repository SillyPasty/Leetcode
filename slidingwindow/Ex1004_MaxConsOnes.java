package slidingwindow;
// Thinking and drawing before coding!!!
public class Ex1004_MaxConsOnes {
    public static void main (String args[]) {
        Ex1004Solution sol = new Ex1004Solution();
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
        int[] A2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int K = A.length;
        System.out.println(sol.longestOnes(A, K));
    }
}

class Ex1004Solution {
    public int longestOnes(int[] A, int K) {
        int maxLen = 0;
        int startIdx = 0, zeroCnt = 0;
        for (int endIdx = 0; endIdx < A.length; endIdx++) {
            if (A[endIdx] == 0)
                zeroCnt++;
            if (zeroCnt > K && A[startIdx++] == 0) 
                zeroCnt--;
            if (zeroCnt <= K)
                maxLen = Math.max(maxLen, endIdx - startIdx + 1);
        }
        return maxLen;
    }
}