#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        deque<int> max_que, min_que;
        int l = 0, r = 0, res = 0;
        for (; r < nums.size(); ++r) {
            while (!max_que.empty() && nums[r] > max_que.back()) {
                max_que.pop_back();
            }
            while (!min_que.empty() && nums[r] < min_que.back()) {
                min_que.pop_back();
            }
            max_que.push_back(nums[r]);
            min_que.push_back(nums[r]);
            while (max_que.front() - min_que.front() > limit) {
                if (max_que.front() == nums[l]) {
                    max_que.pop_front();
                }
                if (min_que.front() == nums[l]) {
                    min_que.pop_front();
                }
                ++l;
            }
            res = max(res, r - l + 1);
        }
        return res;
    }
};