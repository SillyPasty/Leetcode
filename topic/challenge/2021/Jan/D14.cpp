class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& A) {
        int length = A.size();
        vector<bool> result(length);
        int prev = 0;
        for (int i = 0; i < length; ++i) {
            prev *= 2;
            prev %= 5;
            prev += A[i];
            if (prev % 5 == 0)
                result[i] = true;
            else
                result[i] = false;
        }
        return result;
    }
};