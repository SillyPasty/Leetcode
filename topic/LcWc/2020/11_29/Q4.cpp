#include <bits/stdc++.h>
using namespace std;

int minimumDeviation(vector<int>& nums) {
    int n = nums.size();
    set<pair<int, int>> ms;
    for (int i = 0; i < n; ++i) {
        int num = nums[i];
        while (num % 2 == 0)
            num >>= 1;
        ms.emplace(num, i);
    }
    int ans = ms.rbegin()->first - ms.begin()->first;
    while (ms.begin()->first < nums[ms.begin()->second] || ms.begin()->first % 2 == 1) {
        auto [num, idx] = *ms.begin();
        ms.erase(ms.begin());
        ms.emplace(num << 1, idx);
        ans = min(ans, ms.rbegin()->first - ms.begin()->first);
    }
    return ans;
}