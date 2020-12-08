int max_len;
int len;
vector<int> splitIntoFibonacci(string S) {
    max_len = log10((long long)(1) << 31) + 1;
    len = S.length();
    vector<int> res;
    // if (S[0] == '0')
    //     return res;
    for (int i = 1; i <= max_len && i <= len / 2; ++i) {
        for (int j = i + 1; j <= 2 * max_len && j <= len; ++j) {
            vector<int> res;
            if (solute(res, i, j, S)) {
                if (res.size() < 3) continue;
                return res;
            }
        }
    }
    return res;
}
bool solute(vector<int> &tmp, int len_1, int len_2, string &S) {
    if ((len_2 - len_1) != 1 && S[len_1] == '0') {
        // cout << len_2 << " " << len_1 << endl;
        return false;
    }
    if (S[0] == '0' && len_1 > 1) return false;

    int cur_p = len_2;
    if (len_1 > len / 2 || len_2 - len_1 > len / 2) return false;
    string s1 = S.substr(0, len_1), s2 = S.substr(len_1, len_2 - len_1);
    int first = atoi(s1.c_str());
    int second = atoi(s2.c_str());
    // cout << first <<  " " << second << endl;
    tmp.push_back(first);
    tmp.push_back(second);
    int prev_end = cur_p;
    while (cur_p < len) {
        long long cur = (long long)*(tmp.rbegin()) + (long long)*(tmp.rbegin() + 1);
        if (cur > ((long long)(1) << 31) - 1) return false;
        // cout << cur << endl;
        int x;
        ++cur_p;
        while (cur_p <= len) {
            x = atoi(S.substr(prev_end, cur_p - prev_end).c_str());
            if (S[prev_end] == '0' && cur_p - prev_end > 1) return false;
            if (x == cur) break;
            if (x > cur) return false;
            // cout << x << endl;
            ++cur_p;
        }
        if (cur_p == len + 1 && x != cur) return false;
        tmp.push_back(cur);
        prev_end = cur_p;
        // cout << cur << endl;
        // cout << cur << " " << cur_p << len << endl;
    }
    return true;
}