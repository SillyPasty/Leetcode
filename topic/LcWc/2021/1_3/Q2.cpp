#include <unordered_map>
#include <vector>
using namespace std;

int countPairs(vector<int>& deliciousness) {
        long long result = 0;
        unordered_map<int, int> cnt;
        for (auto i : deliciousness) ++cnt[i];
        for (auto [k, v] : cnt) {
            for (int i = 0; i <= 21; ++i) {
                int mask = 1 << i;
                int cmp = mask - k;
                if (cmp < 0)
                    continue;
                if (cmp != k && cnt.count(cmp))
                    result += 1LL * cnt[cmp] * v;
                if (cmp == k && v > 1)
                    result += (1LL * v * (v - 1));
            }
        }
        return result / 2 % static_cast<int>(1e9 + 7);
    }