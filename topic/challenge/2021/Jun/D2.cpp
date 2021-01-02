
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> deq;
        vector<int> result;
        for (int i = 0; i < k - 1; ++i) {
            while (!deq.empty() && nums[deq.back()] < nums[i])
                deq.pop_back();
            deq.push_back(i);
        }
        for (int i = 0; i <= nums.size() - k; ++i) {
            while (!deq.empty() && nums[deq.back()] < nums[i + k - 1])
                deq.pop_back();
            deq.push_back(i + k - 1);
            result.push_back(nums[deq.front()]);
            
            if (deq.front() == i)
                deq.pop_front();
        }
        return result;
    }
};