public class Q2 {
    public String getSmallestString(int n, int k) {
        int a = n;
        int c = (k - n) / 25;
        a -= c;
        int b = k - a - c * 26;
        if (b != 0)
            a--;
        StringBuilder res = new StringBuilder();
        while (a > 0) {
            res.append("a");
            a--;
        }
        if (b > 0)
            res.append(String.valueOf((char)('a' + b)));
        while (c > 0) {
            res.append("z");
            c--;
        }
        return res.toString();
    }
}
