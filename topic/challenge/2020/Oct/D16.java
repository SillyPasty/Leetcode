

public class D16 {
    public int[] sortedSquares(int[] A) {
        int l = 0, r, idx = 0;
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++)
            if (A[i] < 0)
                l = i;
            else
                break;
        r = l + 1;
        while (l >= 0 && r < A.length) {
            int a = sqar(A[l]);
            int b = sqar(A[r]);
            if (a > b) {
                result[idx++] = b;
                r++;
            } else {
                result[idx++] = a;
                l--;
            }
        }
        while (l >= 0)
            result[idx++] = sqar(A[l--]);
        while (r < A.length)
            result[idx++] = sqar(A[r++]);
        return result;
    }

    public int sqar(int a) {
        return a * a;
    }
}
