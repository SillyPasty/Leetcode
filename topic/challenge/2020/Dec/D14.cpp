#include <string>
#include <unordered_map>
#include <vector>
using namespace std;
vector<vector<string>> groupAnagrams(vector<string> &strs) {
    unordered_map<string, vector<string>> m;
    for (auto &str : strs) {
        string tmp = str;
        sort(str.begin(), str.end());
        m[str].push_back(tmp);
    }
    vector<vector<string>> res;
    for (auto &p : m) {
        res.push_back(p.second);
    }
    return res;
}