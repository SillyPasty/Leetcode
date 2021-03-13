#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSubarraySumCircular(vector<int>& A) {
        int a_sum = accumulate(A.begin(), A.end(), 0);
        int dp = 0, min_dp = 0;
        int res = 0;
        for (int i = 0; i < A.size(); ++i) {
            dp = max(dp, 0) + A[i];
            min_dp = min(min_dp, 0) + A[i];
            if (i == 0) res = dp;
            res = max(res, dp);
            if (min_dp != a_sum)
                res = max(res, a_sum - min_dp);
        }
        return res;
    }
};