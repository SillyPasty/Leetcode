#include <bits/stdc++.h>
using namespace std;

vector<int> searchRange(vector<int>& nums, int target) {
    int l = 0, r = nums.size();
    int mid1 = l + (r - l) / 2;
    bool flag = 0;
    while (l < r) {
        if (nums[mid1] == target)
            flag = 1;
        if (nums[mid1] >= target)
            r = mid1;
        else if (nums[mid1] < target)
            l = mid1 + 1;
        mid1 = l + (r - l) / 2;
    }
    if (!flag) {
        vector<int> res({-1, -1});
        return res;
    }
    l = 0, r = nums.size();
    int mid2 = l + (r - l) / 2;
    while (l < r) {
        if (nums[mid2] > target)
            r = mid2;
        else if (nums[mid2] <= target)
            l = mid2 + 1;
        mid2 = l + (r - l) / 2;
    }
    vector<int> res({mid1, mid2 - 1});
    return res;
}