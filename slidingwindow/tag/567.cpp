#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int l = 0, r = 0, cnt = 0;
        unordered_map<char, int> s1_cnt;
        unordered_set<char> s1_flag;
        for (auto s : s1) {
            ++s1_cnt[s];
            s1_flag.insert(s);
        }

        for (; r < s2.size(); ++r) {
            if (s1_flag.find(s2[r]) != s1_flag.end()) {
                while (s1_cnt[s2[r]] == 0) {
                    ++s1_cnt[s2[l++]];
                    --cnt;
                }
                --s1_cnt[s2[r]];
                ++cnt;
                if (cnt == s1.size()) return true;
            } else {
                while (l <= r) {
                    if (s1_flag.find(s2[l]) != s1_flag.end()) {
                        ++s1_cnt[s2[l]];
                        --cnt;
                    }
                    ++l;
                }
            }
        }
        return false;
    }
};