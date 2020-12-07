#include <cstdio>
#include <vector>
using std::vector;

int matrixScore(vector<vector<int>>& A) {
    const int rows = A.size(), cols = A[0].size();
    int res = rows * (1 << (cols - 1));
    for (int col = 1; col < cols; ++col) {
        int ones = 0;
        for (int row = 0; row < rows; ++row)
            if (A[row][0] == A[row][col]) ++ones;
        ones = (ones > rows / 2.0) ? ones : rows - ones;
        res += (ones * (1 << (cols - col - 1)));
    }
    return res;
}