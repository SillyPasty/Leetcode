#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int characterReplacement(string s, int k) {
        vector<int> cnt(26);
        int l = 0, r = 0, maxn = 0;
        for (; r < s.size(); ++r) {
            ++cnt[s[r] - 'A'];
            maxn = max(cnt[s[r] - 'A'], maxn);
            if (r - l - maxn + 1 > k) {
                --cnt[s[l++] - 'A'];
            }
        }
        return r - l;
    }
};