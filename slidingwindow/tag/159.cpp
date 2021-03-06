#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        vector<pair<char, int>> ch(2);
        int cnt = 0;
        int l = 0, r = 0;
        int res = 0;
        for (; r < s.size(); ++r) {
            if (cnt == 0) {
                ch[0] = make_pair(s[r], r);
                ++cnt;
            } else if (cnt == 1) {
                if (ch[0].first == s[r])
                    ch[0].second = r;
                else {
                    ch[1] = make_pair(s[r], r);
                    ++cnt;
                }
            } else {
                if (ch[0].first == s[r])
                    ch[0].second = r;
                else if (ch[1].first == s[r])
                    ch[1].second = r;
                else {
                    if (ch[0].second < ch[1].second) {
                        l = ch[0].second + 1;
                        ch[0].first = s[r];
                        ch[0].second = r;
                    } else {
                        l = ch[1].second + 1;
                        ch[1].first = s[r];
                        ch[1].second = r;
                    }
                }
            }
            res = max(res, (r - l + 1));
        }
        return res;
    }
};