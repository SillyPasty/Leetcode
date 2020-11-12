public class D11 {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 1;
        int[] res = new int[A.length];
        for (int i : A) {
            if (i % 2 == 0) {
                res[even] = i;
                even += 2;
            } else {
                res[odd] = i;
                odd += 2;
            }
        }
        return res;
    }
}
