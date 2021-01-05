vector<vector<int>> largeGroupPositions(string s) {
        vector<vector<int>> result;
        int cur = 0;
        char cur_char = s[0];
        for (int i = 0; i < s.size(); ++i) {
            if (cur_char != s[i]) {
                if (i - cur >= 3) {
                    vector<int> tmp(2);
                    tmp[0] = cur;
                    tmp[1] = i - 1;
                    result.push_back(tmp);
                }
                cur_char = s[i];
                cur = i;
            }
        }
        if (s.size() - cur >= 3) {
            vector<int> tmp(2);
            tmp[0] = cur;
            tmp[1] = s.size() - 1;
            result.push_back(tmp);
        }
        return result;
    }