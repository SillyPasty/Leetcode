#include<vector>
using namespace std;
class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        int n = nums.size();
        vector<int> s(n + 1);
        for (int i = 1; i <= n; ++i)
            s[i] = s[i - 1] + nums[i - 1];
        long long ans = 0;
        int m = 2;
        for (int l = 1; l <= n - 2; ++l) {
            int L = s[l];
            m = max(m, l + 1);
            while (m < n && s[m] - L < L)
                m++;
            if (m == n)
                break;
            int lo = m, hi = n - 1;
            while (lo <= hi) {
                int mid = (lo + hi) >> 1;
                if (s[n] - s[mid] < s[mid] - L)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            ans += hi - m + 1;
        }
        return ans % static_cast<int>(1e9 + 7);
    }
};