#include <unordered_set>
using namespace std;
char findTheDifference(string s, string t) {
    int p = 0;
    for (int i = 0; i < s.size(); i++) {
        p ^= s[i];
        p ^= t[i];
    }
    p ^= t[s.size()];
    return p;
}