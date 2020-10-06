
public class D5{
    public static void main (String[] args) {
        int x = 7;
        System.out.println(new D5().bitwiseComplement(x));
    }
    public int bitwiseComplement(int N) {
        int res = 0, bit = 1;
        if (N == 0)
            return 1;
        while (N != 1 && N != 0) {
            res += (N % 2 == 1) ? 0 : bit;
            N /= 2;
            bit *= 2;
        }
        return res;
    }
}
