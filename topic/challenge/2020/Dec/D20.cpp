#include <stack>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string removeDuplicateLetters(string s) {
        vector<int> cnt(26), cur(26);
        for (auto c : s) ++cnt[c - 'a'];
        stack<char> sta;
        for (auto c : s) {
            if (!cur[c - 'a']) {
                while (!sta.empty() && sta.top() > c) {
                    if (cnt[sta.top() - 'a'] > 0) {
                        cur[sta.top() - 'a'] = 0;
                        sta.pop();
                    } else
                        break;
                }
                sta.push(c);
            }
            cur[c - 'a'] = 1;
            --cnt[c - 'a'];
        }
        string res(sta.size(), ' ');
        int size = sta.size();
        for (int i = 0; i < size; ++i) {
            res[size - i - 1] = sta.top();
            sta.pop();
        }
        return res;
    }
};