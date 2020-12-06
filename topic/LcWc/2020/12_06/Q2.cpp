
#include <unordered_map>
#include <vector>
using namespace std;

int maxOperations(vector<int>& nums, int k) {
    unordered_map<int, int> u_map;
    int res = 0;
    for (auto i : nums)
        ++u_map[i];
    for (auto i : nums) {
        int o = k - i;
        if (!u_map[o])
            continue;
        if (o == i) {
            res += u_map[o] / 2;
            u_map[o] %= 2;
        } else {
            int cnt = min(u_map[i], u_map[o]);
            res += cnt;
            u_map[i] -= cnt;
            u_map[o] -= cnt;
        }
    }
    return res;
}