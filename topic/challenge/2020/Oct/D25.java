
public class D25 {
    public int longestMountain(int[] A) {
        int res = 0, left = 0, right = 0;
        int n = A.length;
        while (left + 2 < n) {
            right = left + 1;
            if (A[left] < A[left+1]) {
                while (right + 1 < n && A[right] < A[right + 1])
                    right++;
                if (right + 1 < n && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right+1])
                        right++;
                    res = Math.max(res, right - left + 1);
                } else {
                    right++;
                }
            }
            left = right;
        }
        return res;
    }
}
