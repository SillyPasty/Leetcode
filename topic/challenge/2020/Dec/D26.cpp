class Solution {
public:
    int candy(vector<int>& ratings) {
        int length = ratings.size();
        vector<int> left(length, 1), right(length, 1);
        for (int i = 1; i < length; ++i)
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        for (int i = length - 2; i >= 0; --i)
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        int result = 0;
        for (int i = 0; i < length; ++i) result += max(left[i], right[i]);
        return result;
    }
};