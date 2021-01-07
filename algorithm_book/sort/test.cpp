#include <algorithm>
#include <cstdlib>
#include <ctime>
#include <vector>
using namespace std;

vector<int> get_vector() {
    srand(time(NULL));
    int length = rand();
    vector<int> vec(length);
    for (auto i = 0; i < length; ++i) vec[i] = rand();
    return vec;
}

bool check(vector<int> origin, vector<int> &sorted) {
    sort(origin.begin(), origin.end());
    for (auto i = 0; i < origin.size(); ++i)
        if (origin[i] != sorted[i]) return false;
    return true;
}