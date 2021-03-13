#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int cur_cost = 0, l = 0, r = 0, res = 0;
        for (; r < s.size(); ++r) {
            cur_cost += abs(s[r] - t[r]);
            while (cur_cost > maxCost) {
                cur_cost -= abs(s[l] - t[l]);
                ++l;
            }
            res = max(res, r - l + 1);
        }
        return res;
    }
};