class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int max_r = 0;
        vector<int> diff(s.length());
        for (int i = 0; i < s.length(); i++) {
            diff[i] = abs(s[i] - t[i]);
        }
        int l = 0;
        int sum = 0;
        for (int r = 0; r < s.size(); ++r) {
            sum += diff[r];
            while (sum > maxCost) {
                sum -= diff[l];
                ++l;
            }
            max_r = max(max_r, r - l + 1);
        }
        return max_r;
    }
};