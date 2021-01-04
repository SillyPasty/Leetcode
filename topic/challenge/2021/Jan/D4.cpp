int fib(int n) {
        int res = 0, f1 = 0, f2 = 1;
        for (int i = 0; i < n; ++i) {
            res = f2;
            f2 += f1;
            f1 = res;
        }
        return res;
    }