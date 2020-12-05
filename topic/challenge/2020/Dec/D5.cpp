#include <bits/stdc++.h>
using namespace std;

int leastInterval(vector<char>& tasks, int n) {
    int timer[26], task_cnt[26] = {0}, cnt = 0;
    int size = tasks.size();
    for (int i = 0; i < 26; ++i)
        timer[i] = -1;
    for (auto c : tasks)
        ++task_cnt[c - 'A'];
    while (size) {
        char cur = ' ';
        int max_cnt = 0;
        for (int i = 0; i < 26; ++i) {
            if (task_cnt[i] && (timer[i] == -1 || cnt - timer[i] > n)) {
                if (task_cnt[i] > max_cnt ||
                    (task_cnt[i] == max_cnt && timer[i] < timer[cur - 'A'])) {
                    max_cnt = task_cnt[i];
                    cur = i + 'A';
                }
            }
        }
        if (cur != ' ') {
            --task_cnt[cur - 'A'];
            --size;
            timer[cur - 'A'] = cnt;
        }
        ++cnt;
    }
    return cnt;
}
int leastInterval2(vector<char>& tasks, int n) {
    int len = tasks.size();
    vector<int> vec(26);
    for (char c : tasks)
        ++vec[c - 'A'];
    sort(vec.rbegin(), vec.rend());
    int cnt = 1;
    while (cnt < vec.size() && vec[cnt] == vec[0])
        cnt++;
    return max(len, cnt + (n + 1) * (vec[0] - 1));
}