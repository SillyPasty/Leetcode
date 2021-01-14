class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> result;
        if (!nums.size())
            return result;
        int left = nums[0];
        int right = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] == right + 1) {
                right = nums[i];
                continue;
            }
            if (right == left)
                result.push_back(to_string(left));
            else
                result.push_back(to_string(left) + "->" + to_string(right));
            left = nums[i];
            right = nums[i];
        }
        if (right == left)
                result.push_back(to_string(left));
        else
            result.push_back(to_string(left) + "->" + to_string(right));
        return result;
    }
};