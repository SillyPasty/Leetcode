#include <bits/stdc++.h>
using namespace std;
string sortString(string s) {
    const int len = s.size();
    int bucket[26] = {0};
    for (char c : s)
        ++bucket[c - 'a'];
    string res;
    while (1) {
        for (int i = 0; i < 26 && res.size() < len; i++) {
            if (bucket[i]) {
                res.push_back('a' + i);
                --bucket[i];
            }
        }
        for (int i = 25; i >= 0 && res.size() < len; i--) {
            if (bucket[i]) {
                res.push_back('a' + i);
                --bucket[i];
            }
        }
        if (res.size() >= len)
            break;
    }
    return res;
}