#include <vector>
int dp[1005][1005];
using namespace std;
int stoneGameVII(vector<int> &stones) {
    int stoneGameVII(vector<int> & stones) {
        int n = stones.size();
        for (int i = 1; i <= n; ++i) dp[i][i] = 0;
        vector<int> sum{0};
        for (int stone : stones) sum.emplace_back(sum.back() + stone);
        for (int len = 2; len <= n; ++len)
            for (int l = 1; l + len - 1 <= n; ++l) {
                int r = l + len - 1;
                dp[l][r] = max(sum[r] - sum[l] - dp[l + 1][r],
                               sum[r - 1] - sum[l - 1] - dp[l][r - 1]);
            }
        return dp[1][n];
    }
}
