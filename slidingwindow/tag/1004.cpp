#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestOnes(vector<int>& A, int K) {
        int l = 0, r = 0, res = 0;
        for (; r < A.size(); ++r) {
            if (A[r] == 0) {
                while (K == 0) {
                    if (A[l++] == 0) ++K;
                }
                --K;
            }
            res = max(res, r - l + 1);
        }
        return res;
    }
};