package slidingwindow;

public class Ex978_LongestTurbulentSubarray {
    public static void main (String args[]) {
        Ex978Solution sol = new Ex978Solution();
        int array[] = {0,1,1,0,1,0,1,1,0,0};
        int array2[] = {4, 8, 4, 16};
        int array3[] = {100};
        System.out.println(sol.maxTurbulenceSize(array));
    }
}

class Ex978Solution {
    public int maxTurbulenceSize(int[] A) {
        int maxLen = 1, startIdx = 0;
        for (int endIdx = 1; endIdx < A.length; endIdx++) {
            if ((endIdx - 1) % 2 == 0) {
                if (A[endIdx - 1] >= A[endIdx]) {
                    startIdx = endIdx;
                }
            } else {
                if (A[endIdx - 1] <= A[endIdx]) {
                    startIdx = endIdx;
                }
            }
            maxLen = Math.max(maxLen, endIdx - startIdx + 1);
        }
        startIdx = 0;
        for (int endIdx = 1; endIdx < A.length - 1; endIdx++) {
            if ((endIdx - 1) % 2 == 0) {
                if (A[endIdx - 1] <= A[endIdx]) {
                    startIdx = endIdx;
                }
            } else {
                if (A[endIdx - 1] >= A[endIdx]) {
                    startIdx = endIdx;
                }
            }
            maxLen = Math.max(maxLen, endIdx - startIdx + 1);
        }

        return maxLen;
    }
}