#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> t_cnt, cur_cnt;
        int l = 0, r = 0, cur_len = 0, res = INT32_MAX, res_l = -1, res_r = ;
        for (char c : t) ++t_cnt[c];
        for (; r < s.size(); ++r) {
            ++cur_cnt[s[r]];
            if (cur_cnt[s[r]] <= t_cnt[s[r]]) cur_len++;
            while (cur_len == t.size()) {
                if (r - l + 1 < res) {
                    res = r - l + 1;
                    res_l = l;
                    res_r = r;
                }
                if (cur_cnt[s[l]] == t_cnt[s[l]]) {
                    --cur_len;
                }
                --cur_cnt[s[l]];
                ++l;
            }
        }
        if (res_l == -1) return "";
        return s.substr(res_l, res_r - res_l + 1);
    }
};