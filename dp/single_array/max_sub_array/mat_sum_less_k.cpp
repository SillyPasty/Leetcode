#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        int r_size = matrix.size();
        bool is_updated = false;
        if (r_size == 0)
            return 0;
        int l_size = matrix[0].size();
        int res = 0, res_x1, res_x2, res_y1, res_y2;
        for (int rowl = 0; rowl < r_size; ++rowl) {
            vector<int> col_sum(l_size);
            for (int rowh = rowl; rowh < r_size; ++rowh) {
                for (int col = 0; col < l_size; ++col) {
                    col_sum[col] += matrix[rowh][col];
                }

                for (int i = 0; i < l_size; ++i) {
                    int cur = 0;
                    for (int j = i; j < l_size; ++j) {
                        cur += col_sum[j];
                        if (cur == k)
                            return k;
                        if (cur < k && !is_updated) {
                            is_updated = true;
                            res = cur;
                        }
                        if (cur < k && cur > res)
                            res = cur;
                    }
                }
            }
        }
        return res;
    }
};