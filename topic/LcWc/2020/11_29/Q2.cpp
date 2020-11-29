#include <bits/stdc++.h>
using namespace std;
vector<int> mostCompetitive(vector<int>& nums, int k) {
    k = nums.size() - k;
    vector<int> stk;
    for (auto& digit : nums) {
        while (stk.size() > 0 && stk.back() > digit && k) {
            stk.pop_back();
            k -= 1;
        }
        stk.push_back(digit);
    }

    for (; k > 0; --k) {
        stk.pop_back();
    }
    return stk;
}