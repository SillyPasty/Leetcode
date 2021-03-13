#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> c_map;
        int l = 0, r = 0;
        int res = 0;
        for (; r < s.size(); ++r) {
            ++c_map[s[r]];
            while (c_map[s[r]] > 1) {
                --c_map[s[l++]];
            }
            res = max(res, r - l + 1);
        }
        return res;
    }
};