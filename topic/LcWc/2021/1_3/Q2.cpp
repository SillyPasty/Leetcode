#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>
using namespace std;

class pair_hash {
    public:
    template <class T1, class T2>
    std::size_t operator () (std::pair<T1, T2> const &pair) const
    {
        std::size_t h1 = std::hash<T1>()(pair.first);
        std::size_t h2 = std::hash<T2>()(pair.second);
        return h1 ^ h2;
    }
};
class Solution {
public:
        int countPairs(vector<int>& deliciousness) {
        unordered_map<int, int> map;
        unordered_set<pair<int, int>, pair_hash> set;
        int binary_exp[22];
        binary_exp[0] = 1;
        for (int i = 1; i <= 21; ++i)
            binary_exp[i] = binary_exp[i - 1] << 1;
        for (auto i : deliciousness) {
            ++map[i];
        }
        int result = 0;
        for (auto iter = map.begin(); iter != map.end(); ++iter) {
            int val = iter->first;
            int cnt = iter->second;
            for (int i = 0; i <= 21; ++i) {
                if (binary_exp[i] <= val)
                    continue;
                int val2 = binary_exp[i] - val;
                if (map.count(val2)) {
                    pair<int, int> p1 = make_pair(val, val2);
                    pair<int, int> p2 = make_pair(val2, val);
                    if (set.count(p1))
                        continue;
                    set.insert(p1);
                    set.insert(p2);
                    if (val2 == val) result += map[val2] * (map[val2] - 1) / 2;
                    else result += cnt * map[val2];
                    result %= static_cast<int>(1e9) + 7;
                }   
            }
        }
        return result;
    }
};
