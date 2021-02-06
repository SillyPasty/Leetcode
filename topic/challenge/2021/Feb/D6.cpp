class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int window_size = cardPoints.size() - k;
        int result = 0;
        int sum = accumulate(cardPoints.cbegin(), cardPoints.cend(), 0);
        int window_sum =
            accumulate(cardPoints.cbegin(), cardPoints.cbegin() + window_size, 0);
        result = sum - window_sum;
        for (int i = 1; i <= cardPoints.size() - window_size; ++i) {
            window_sum -= cardPoints[i - 1];
            window_sum += cardPoints[i + window_size - 1];
            result = max(result, sum - window_sum);
        }
        return result;
    }
};