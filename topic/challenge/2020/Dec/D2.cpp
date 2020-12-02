#include <bits/stdc++.h>
using namespace std;

vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
    vector<int> result;
    for (int i = 0; i <= k; ++i) {
        if (i > nums1.size() || k - i > nums2.size())
            continue;
        vector<int> s1 = get_max(nums1, i);
        vector<int> s2 = get_max(nums2, k - i);
        vector<int> tmp(merge(s1, s2));
        if (result.empty() || result < tmp)
            result.assign(tmp.begin(), tmp.end());
    }
    return result;
}

vector<int> get_max(vector<int>& nums, int k) {
    vector<int> s;
    k = nums.size() - k;
    for (auto num : nums) {
        while (s.size() > 0 && s.back() < num && k) {
            s.pop_back();
            --k;
        }
        s.push_back(num);
    }
    for (; k > 0; --k)
        s.pop_back();
    return s;
}

vector<int> merge(vector<int>& s1, vector<int>& s2) {
    if (s1.size() == 0)
        return s2;
    if (s2.size() == 0)
        return s1;
    vector<int> ret(s1.size() + s2.size());
    int idx1 = 0, idx2 = 0;
    for (int i = 0; i < s1.size() + s2.size(); ++i) {
        if (cmp(s1, idx1, s2, idx2) > 0)
            ret[i] = s1[idx1++];
        else
            ret[i] = s2[idx2++];
    }
    return ret;
}

int cmp(vector<int>& ss1, int idx1, vector<int>& ss2, int idx2) {
    while (idx1 < ss1.size() && idx2 < ss2.size()) {
        if (!(ss1[idx1] - ss2[idx2]))
            return ss1[idx1] - ss2[idx2];
        idx1++;
        idx2++;
    }
    return (ss1.size() - idx1) - (ss2.size() - idx2);
}