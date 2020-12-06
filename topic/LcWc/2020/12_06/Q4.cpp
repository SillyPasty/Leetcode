#include <deque>
#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;
int res;
int bucket_size;
void calculate(vector<vector<int>> &buckets) {
    int tmp = 0;
    for (auto bucket : buckets) {
        int mini = bucket[0];
        int maxi = bucket[0];
        for (auto val : bucket) {
            mini = min(val, mini);
            maxi = max(val, maxi);
            cout << val << ' ';
        }
        cout << endl;
        tmp += (maxi - mini);
    }
    res = min(tmp, res);
}

int minimumIncompatibility(vector<int> &nums, int k) {
    res = INT32_MAX;
    deque<int> numbers(nums.begin(), nums.end());
    bucket_size = nums.size() / k;
    vector<vector<int>> buckets(k);
    int is_in_bucket[k][17];
    unordered_map<int, int> count;
    for (auto num : nums) {
        ++count[num];
        if (count[num] > k)
            return -1;
    }
    for (int i = 0; i < k; ++i)
        for (int j = 0; j < 17; ++j)
            is_in_bucket[i][j] = 0;
    dfs(numbers, buckets, is_in_bucket);
    return res;
}

void dfs(deque<int> &nums, vector<vector<int>> &buckets, int is_in_bucket[][17]) {
    if (nums.empty()) {
        calculate(buckets);
        return;
    }
    int cur_num = nums.front();
    for (int i = 0; i < buckets.size(); ++i) {
        if (!is_in_bucket[i][cur_num] && buckets[i].size() <= bucket_size) {
            nums.pop_front();
            is_in_bucket[i][cur_num] = 1;
            buckets[i].push_back(cur_num);
            dfs(nums, buckets, is_in_bucket);
            nums.push_front(cur_num);
            buckets[i].pop_back();
            is_in_bucket[i][cur_num] = 0;
        }
    }
}