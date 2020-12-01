#include <bits/stdc++.h>
using namespace std;

string reorganizeString(string S) {
    int max_len = S.size() / 2 + S.size() % 2;
    int count[26] = {0};
    for (auto c : S) {
        ++count[c - 'a'];
        if (count[c - 'a'] > max_len)
            return "";
    }
    auto cmp = [&](const char& letter1, const char& letter2) {
        return count[letter1 - 'a'] < count[letter2 - 'a'];
    };
    priority_queue<char, vector<char>, decltype(cmp)> queue{cmp};
    for (char c = 'a'; c <= 'z'; ++c) {
        if (count[c - 'a'])
            queue.push(c);
    }
    string buf = "";
    while (queue.size() > 1) {
        char ch1 = queue.top();
        queue.pop();
        char ch2 = queue.top();
        queue.pop();
        buf += ch1;
        buf += ch2;
        if (--count[ch1 - 'a'])
            queue.push(ch1);
        if (--count[ch2 - 'a'])
            queue.push(ch2);
    }
    if (queue.size())
        buf += queue.top();
    return buf;
}