#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minSwaps(vector<int>& data) {
        int one_sum = accumulate(data.begin(), data.end(), 0);
        int l = 0, r = 0, cur_sum = 0, res = 0;
        for (; r < data.size(); ++r) {
            cur_sum += data[r];
            if (r - l + 1 > one_sum) {
                cur_sum -= data[l++];
            }
            res = max(res, cur_sum);
        }
        return one_sum - res;
    }
};