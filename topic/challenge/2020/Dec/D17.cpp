#include <vector>
using std::vector;
int maxProfit(vector<int>& prices, int fee) {
    int cash = 0, hold = -prices[0];
    for (int i = 1; i < prices.size(); ++i) {
        hold = max(cash - prices[i], hold);
        cash = max(cash, hold + prices[i] - fee);
    }
    return cash;
}