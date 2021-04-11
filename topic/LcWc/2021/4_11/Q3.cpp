#include <bits/stdc++.h>
using namespace std;

int minSideJumps(vector<int>& obstacles) {
    int size = obstacles.size();
    vector<vector<int>> dp(size, vector<int>(3, INT_MAX));
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[0][2] = 1;
    for (int i = 1; i < size; ++i) {
        int cur_obs = obstacles[i];
        int cur_min = INT_MAX;
        for (int j = 0; j < 3; ++j) {
            if (j == (cur_obs - 1))
                dp[i][j] = -1;
            else if (dp[i - 1][j] != -1) {
                dp[i][j] = dp[i - 1][j];
                cur_min = min(dp[i][j], cur_min);
            }
        }
        for (int j = 0; j < 3; ++j) {
            if (dp[i][j] != -1) dp[i][j] = min(dp[i][j], cur_min + 1);
        }
    }
    int res = INT_MAX;
    for (int i = 0; i < 3; ++i)
        if (dp[size - 1][i] != -1) res = min(res, dp[size - 1][i]);
    return res;
}