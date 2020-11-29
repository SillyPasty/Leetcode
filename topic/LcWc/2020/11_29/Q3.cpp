#include <bits/stdc++.h>
using namespace std;

int minMoves(vector<int>& nums, int limit) {
    int n = nums.size();
    vector<int> delta(limit * 2 + 2);
    for (int i = 0; i < n / 2; ++i) {
        int lo = 1 + min(nums[i], nums[n - i - 1]);
        int hi = limit + max(nums[i], nums[n - i - 1]);
        int sum = nums[i] + nums[n - i - 1];
        delta[lo]--;
        delta[sum]--;
        delta[sum + 1]++;
        delta[hi + 1]++;
        for (auto iter = delta.begin(); iter != delta.end(); ++iter) {
            cout << *iter << " ";
        }
        cout << endl;
    }
    int now = n;
    int ans = n;
    for (int i = 2; i <= limit * 2; ++i) {
        now += delta[i];
        ans = min(ans, now);
    }
    return ans;
}

int main() {
    vector<int> nums({1, 2, 4, 3});
    int limit = 4;
    minMoves(nums, limit);
    return 0;
}