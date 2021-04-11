#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> getMaxMatrix(vector<vector<int>>& matrix) {
        int r_size = matrix.size();
        if (r_size == 0)
            return vector<int>();
        int l_size = matrix[0].size();
        int res = 0, res_x1, res_x2, res_y1, res_y2;
        for (int rowl = 0; rowl < r_size; ++rowl) {
            vector<int> col_sum(l_size);
            for (int rowh = rowl; rowh < r_size; ++rowh) {
                for (int col = 0; col < l_size; ++col) {
                    col_sum[col] += matrix[rowh][col];
                }
                int dp = 0, cur_left = 0;
                for (int col = 0; col < l_size; ++col) {
                    if (dp < 0) {
                        dp = 0;
                        cur_left = col;
                    } 
                    dp += col_sum[col];
                    if (rowh == 0 && col == 0)
                        res = dp;
                    else if (dp > res) {
                        res = dp;
                        res_y1 = cur_left;
                        res_y2 = col;
                        res_x1 = rowl;
                        res_x2 = rowh;
                    }
                }
            }
        }
        return vector<int>{res_x1, res_y1, res_x2, res_y2};
    }
};