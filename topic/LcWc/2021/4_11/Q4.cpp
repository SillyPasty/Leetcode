#include <bits/stdc++.h>
using namespace std;

class MKAverage {
private:
    map<int, int> averages;
    vector<int> tmp;
    unordered_map<int, int> tmp_delete;
    queue<int> m_queue;
    long long cur_sum;
    int size;
    priority_queue<int, vector<int>, greater<int>> s_heap;
    priority_queue<int, vector<int>, less<int>> m_heap;
    int average_size;
    int m, k;

private:
    void check_deleted() {
        while (tmp_delete[s_heap.top()]) {
            --tmp_delete[s_heap.top()];
            s_heap.pop();
        }
        while (tmp_delete[m_heap.top()]) {
            --tmp_delete[m_heap.top()];
            m_heap.pop();
        }
    }

    void build() {
        sort(tmp.begin(), tmp.end());
        for (int i = 0; i < k; ++i) {
            m_heap.push(tmp[i]);
            s_heap.push(tmp[m - 1 - i]);
            cur_sum -= (tmp[i] + tmp[m - 1 - i]);
        }
        for (int i = k; i < m - k; ++i) {
            ++averages[tmp[i]];
        }
    }

public:
    MKAverage(int m, int k) {
        this->m = m;
        this->k = k;
        cur_sum = 0;
        size = 0;
        average_size = m - 2 * k;
    }

    void addElement(int num) {
        m_queue.push(num);
        if (size < m) {
            tmp.push_back(num);
            cur_sum += num;
            ++size;
            if (size == m) build();
            return;
        }
        check_deleted();
        // delete
        int cur_deleted = m_queue.front();
        m_queue.pop();
        int left_top = m_heap.top();
        int right_bot = s_heap.top();
        auto it = averages.begin();
        auto rit = averages.rbegin();
        int averages_min = it->first;
        int averages_max = rit->first;
        // cout << averages_min << "," << averages_max << endl;
        if (cur_deleted > left_top && cur_deleted < right_bot) {
            --averages[cur_deleted];
            if (averages[cur_deleted] == 0) averages.erase(cur_deleted);
            cur_sum -= cur_deleted;
        } else if (cur_deleted <= left_top) {
            if (cur_deleted == left_top) {
                m_heap.pop();
            } else {
                ++tmp_delete[cur_deleted];
            }
            m_heap.push(averages_min);
            --averages[averages_min];
            if (averages[averages_min] == 0) averages.erase(averages_min);
            cur_sum -= averages_min;
        } else {
            if (cur_deleted == right_bot) {
                s_heap.pop();
            } else {
                ++tmp_delete[cur_deleted];
            }
            s_heap.push(averages_max);
            --averages[averages_max];
            if (averages[averages_max] == 0) averages.erase(averages_max);
            cur_sum -= averages_max;
        }
        // insert
        int inserted = 0;
        if (m_heap.top() <= num && num <= s_heap.top()) {
            inserted = num;
        } else if (m_heap.top() > num) {
            inserted = m_heap.top();
            m_heap.pop();
            m_heap.push(num);
        } else {
            inserted = s_heap.top();
            s_heap.pop();
            s_heap.push(num);
        }
        ++averages[inserted];
        cur_sum += inserted;
        // cout << cur_sum << endl;
    }

    int calculateMKAverage() {
        if (size < m) return -1;
        return cur_sum / average_size;
    }
};