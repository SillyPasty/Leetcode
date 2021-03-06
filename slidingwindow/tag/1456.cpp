#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxVowels(string s, int k) {
        unordered_set<char> yy;
        vector<char> targets{'a', 'e', 'i', 'o', 'u'};
        for (auto c : targets) yy.insert(c);
        int l = 0, r = 0, res = 0, ret = 0;
        for (; r < s.size(); ++r) {
            if (yy.find(s[r]) != yy.end()) ++res;
            ret = max(res, ret);
            if (r - l + 1 == k) {
                if (yy.find(s[l]) != yy.end()) --res;
                ++l;
            }
        }
        return ret;
    }
};