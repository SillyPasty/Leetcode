#include <string>
using std::string;
int monotoneIncreasingDigits(int N) {
    string s = std::to_string(N);
    int idx = 0;
    for (; idx < s.size() - 1 && s[idx + 1] >= s[idx]; ++idx)
        ;
    if (idx == s.size() - 1) return N;
    for (; idx >= 0 && s[idx + 1] < s[idx]; --idx)
        s[idx] = s[idx] == '0' ? '0' : static_cast<char>(s[idx] - 1);
    ++idx;
    for (int i = idx + 1; i < s.size(); ++i) s[i] = '9';
    return atoi(s.c_str());
}