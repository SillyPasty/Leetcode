#include <vector>
using namespace std;

int minPatches(vector<int>& nums, int n) {
    int result = 0, index = 0;
    long long x = 1;
    while (x <= n) {
        if (index < nums.size() && nums[index] <= x) {
            x += nums[index];
            ++index;
        } else {
            x <<= 1;
            ++result;
        }
    }
    return result;
}