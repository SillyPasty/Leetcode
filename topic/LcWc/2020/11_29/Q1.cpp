#include <bits/stdc++.h>
using namespace std;
int maximumWealth(vector<vector<int>>& accounts) {
    int res = 0;
    for (auto iterv = accounts.begin(); iterv != accounts.end(); ++iterv) {
        int tmp = 0;
        for (auto iter = (*iterv).begin(); iter != (*iterv).end(); ++iter) {
            tmp += *iter;
        }
        res = max(res, tmp);
    }
    return res;
}