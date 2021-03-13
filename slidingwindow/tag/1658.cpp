#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (x > sum) return -1;
        int left = 0, right = 0, cur_sum = 0;
        int result = -1;
        for (; right < nums.size(); ++right) {
            cur_sum += nums[right];
            while (cur_sum > sum - x) {
                cur_sum -= nums[left++];
            }
            if (cur_sum == sum - x) {
                if (result == -1)
                    result = nums.size() - (right - left + 1);
                else
                    result =
                        min(result, static_cast<int>(nums.size() - (right - left + 1)));
            }
        }
        return result;
    }
};