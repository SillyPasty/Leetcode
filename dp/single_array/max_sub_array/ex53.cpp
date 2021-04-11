#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        int dp = 0, res = 0;
        for (int i = 0; i < nums.size(); ++i) {
            dp = max(dp, 0) + nums[i];
            if (i == 0)
                res = dp;
            else
                res = max(dp, res);
        }
        return res;
    }
};