#include <bits/stdc++.h>
using namespace std;

int merge(int l, int r, vector<int>& nums) {
    int m = (l + r) / 2;
    int left = l, right = m, idx = 0;
    int res = 0;
    vector<int> tmp(r - l);
    while (left < m) {
        while (right < r && static_cast<long long>(nums[right]) * 2 <
                                static_cast<long long>(nums[left]))
            ++right;
        res += (right - m);
        ++left;
    }
    right = m, left = l;
    while (left < m && right < r) {
        if (nums[left] <= nums[right]) {
            tmp[idx++] = nums[left++];
        } else {
            tmp[idx++] = nums[right++];
        }
    }
    while (left < m) {
        tmp[idx++] = nums[left++];
    }
    while (right < r) {
        tmp[idx++] = nums[right++];
    }
    for (auto i = l; i < r; ++i) {
        nums[i] = tmp[i - l];
    }
    return res;
}

int split(int l, int r, vector<int>& nums) {
    if (l == r || l == r - 1)
        return 0;
    int m = (l + r) / 2;
    int res = 0;
    res += split(l, m, nums);
    res += split(m, r, nums);
    res += merge(l, r, nums);
    return res;
}

int reversePairs(vector<int>& nums) {
    return split(0, nums.size(), nums);
}