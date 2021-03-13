#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int l = 0, r = 0;
        int sum = accumulate(cardPoints.begin(), cardPoints.end(), 0);
        int res = 0, cur_sum = 0;
        for (; r < cardPoints.size(); ++r) {
            cur_sum += cardPoints[r];
            if ((r - l) == (cardPoints.size() - k)) {
                cur_sum -= cardPoints[l++];
                res = min(res, cur_sum);
            } else if (r - l + 1 == cardPoints.size() - k) {
                res = cur_sum;
            }
        }
        return sum - res;
    }
};