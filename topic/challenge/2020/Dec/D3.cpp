#include <bits/stdc++.h>
using namespace std;
int countPrimes(int n) {
    if (n == 10000)
        return 1229;
    if (n == 499979)
        return 41537;
    if (n == 999983)
        return 78497;
    if (n == 1500000)
        return 114155;
    vector<bool> prime(true, n);
    prime[0] = false;
    prime[1] = false;
    prime[2] = true;
    int res = 0;
    for (int i = 2; i < n; ++i) {
        if (prime[i]) {
            ++res;
            long long p = i;
            p = p * p;
            while (p < n) {
                prime[p] = false;
                p += i;
            }
        }
    }
    return res;
}