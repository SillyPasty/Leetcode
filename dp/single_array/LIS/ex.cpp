#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        vector<int> dp(nums.size(), 1);
        vector<int> cnt(nums.size(), 0);
        int res = 0;
        unordered_map<int, int> counter;
        for (int i = 0; i < nums.size(); ++i) {
            unordered_map<int, int> tmp_counter;
            tmp_counter[1] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                    tmp_counter[dp[j] + 1] += cnt[j];
                }
            }
            cnt[i] = tmp_counter[dp[i]];
            counter[dp[i]] += tmp_counter[dp[i]];
            res = max(dp[i], res);
        }
        // cout << res;
        return counter[res];
    }
};