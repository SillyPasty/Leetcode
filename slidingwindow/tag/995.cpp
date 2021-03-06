#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minKBitFlips(vector<int>& A, int K) {
        int l = 0, r = 0, cur_flap = 0, res = 0;
        for (; r < A.size(); ++r) {
            if ((cur_flap == 1 && A[r] == 1) || (cur_flap == 0 && A[r] == 0)) {
                if (r > A.size() - K) return -1;
                A[r] = 2;
                cur_flap = !cur_flap;
                ++res;
            }
            if (r - l + 1 >= K) {
                if (A[l++] == 2) cur_flap = !cur_flap;
            }
        }
        return res;
    }
};