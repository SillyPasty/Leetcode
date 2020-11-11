public class lc786 {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int l = 0, r = 1;
        int[] and = new int[] {0, 1};
        while (r - l > 1e-9) {
            double m = (l + r) / 2.0;
            int[] result = cntUnder(m, A);
            if (result[0] < K) {
                l = m;
            } else {
                ans[0] = res[2];
                ans[1] = res[1];
                r = m;
            }
        }
        return ans
    }
    public int[] cntUnder(double x, int[] primes) {
        int numer = 0, denom = 1, count = 0, j = -1;
        for (int i = 1; i < primes.length; i++) {
            while (primes[j+1] < primes[i] * x)
                j++;
            count += j + 1;
            if (j >= 0 && primes[i] * numer < primes[j] * denom) {
                denom = primes[i];
                numer = primes[j];
            }
        }
        return new int[] {count, denom, numer};
    }
}
