#include <bits/stdc++.h>
using namespace std;

int leastInterval(vector<char>& tasks, int n) {
    int timer[26], cnt = 0;
    for (int i = 0; i < 26; ++i)
        timer[i] = -1;
    map<char, int> task_cnt;
    for (auto c : tasks)
        ++task_cnt[c];
    while (task_cnt.size()) {
        char cur = ' ';
        for (auto iter = task_cnt.begin(); iter != task_cnt.end(); ++iter) {
            if (timer[iter->first - 'A'] == -1 || cnt - timer[iter->first - 'A'] > n) {
                cur = iter->first;
                break;
            }
        }
        if (cur != ' ') {
            --task_cnt[cur];
            timer[cur - 'A'] = cnt;
            if (!task_cnt[cur])
                task_cnt.erase(cur);
        }
        ++cnt;
    }
    return cnt;
}