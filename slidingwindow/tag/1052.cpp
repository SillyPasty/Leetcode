#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int X) {
        int res = 0, cur_sat = 0;
        int l = 0, r = 0;
        int len = customers.size();
        for (int i = 0; i < len; ++i) {
            if (grumpy[i] == 0) cur_sat += customers[i];
        }
        for (; r < len; ++r) {
            if (grumpy[r] == 1) cur_sat += customers[r];
            if (r - l == X) {
                if (grumpy[l] == 1) cur_sat -= customers[l];
                ++l;
            }
            res = max(cur_sat, res);
        }
        return res;
    }
};