#include <bits/stdc++.h>
using namespace std;
bool isPossible(vector<int>& nums) {
    unordered_map<int, int> cnt, last;
    for (auto i : nums)
        ++cnt[i];
    for (auto i : nums) {
        if (cnt[i]) {
            if (last[i - 1]) {
                --last[i - 1];
                ++last[i];
                --cnt[i];
            } else if (cnt[i + 1] && cnt[i + 2]) {
                --cnt[i + 1];
                --cnt[i + 2];
                --cnt[i];
                ++last[i + 2];
            } else
                return false;
        }
    }
    return true;
}