#include<vector>
using namespace std;
class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        vector<long long> diff(nums.size());
        diff[0] = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            diff[i] = diff[i - 1] + nums[i];
        }
        int result = 0;
        for (int i = 0; i < nums.size() - 2; ++i) {
            int left_sum = diff[i];
            int mid_sum, right_sum;
            for (int j = i + 1; j < nums.size() - 1; ++j) {
                mid_sum = diff[j] - diff[i];
                right_sum = diff[nums.size() - 1] - diff[j];
                if (mid_sum > right_sum)
                    break;
                if (left_sum > mid_sum)
                    continue;
                ++result;
                result %= static_cast<int>(1e9) + 7;
            }
            if (left_sum > mid_sum)
                break;
        }   
        return result;
    }
};