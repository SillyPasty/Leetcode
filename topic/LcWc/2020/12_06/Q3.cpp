#include <iostream>
using namespace std;
int concatenatedBinary(int n);
int main() {
    concatenatedBinary(12);
}

int concatenatedBinary(int n) {
    long long res = 0;
    for (int i = 1; i <= n; ++i) {
        int mask = 1 << 17;
        int tmp = i;
        while (mask > tmp)
            mask >>= 1;
        while (mask) {
            res <<= 1;
            res %= static_cast<int>(1e9 + 7);
            res += ((tmp & mask) / mask);
            mask >>= 1;
        }
    }
    return res;
}