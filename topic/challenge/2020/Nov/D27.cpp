class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
       unordered_map<int, int> m;
        int res = 0;
        for (const int a: A)
            for (const int b: B)
                ++m[a + b];
        for (const int c: C)
            for (const int d: D)
                if (m.count(-c-d))
                    res += m[-c-d];
        return res;
    }
};