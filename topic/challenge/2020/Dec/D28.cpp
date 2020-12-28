#include <vector>
using namespace std;

int maxProfit(int k, vector<int>& prices) {
    int size = prices.size();
    if (size == 0) return 0;
    if (k >= size / 2) return quickProfit(prices);
    vector<vector<int>> dp(k + 1);
    for (int i = 0; i < k + 1; ++i) {
        vector<int> tmp(size);
        dp[i] = tmp;
    }
    for (int i = 1; i <= k; ++i) {
        int tmpMax = -prices[0];
        for (int j = 1; j < size; ++j) {
            dp[i][j] = max(dp[i][j - 1], prices[j] + tmpMax);
            tmpMax = max(dp[i - 1][j - 1] - prices[j], tmpMax);
        }
    }
    return dp[k][size - 1];
}
int quickProfit(vector<int>& prices) {
    int result = 0;
    for (int i = 1; i < prices.size(); ++i) {
        if (prices[i] > prices[i - 1]) result += (prices[i] - prices[i - 1]);
    }
    return result;
}