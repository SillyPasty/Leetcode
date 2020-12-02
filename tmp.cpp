#include <bits/stdc++.h>
using namespace std;

int main() {
    vector<int> v({1, 2, 3});
    vector<int> vc1(v);
    vector<int> vc2;
    vc2.assign(v.begin(), v.end());
    v[1] = 5;
    for (auto i : vc1)
        cout << i << " ";
    cout << endl;
    for (auto i : vc2)
        cout << i << " ";
}