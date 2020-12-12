#include <stack>
#include <vector>
using namespace std;
int wiggleMaxLength(vector<int>& nums) {
    if (!nums.size()) return 0;
    stack<int> s;
    for (int i = 1; i < nums.size(); ++i) {
        int diff = nums[i] - nums[i - 1];
        if (!diff) continue;
        if (s.empty()) {
            s.push(diff);
            continue;
        }
        if ((s.top() > 0 && diff > 0) || (s.top() < 0 && diff < 0)) {
            diff += s.top();
            s.pop();
        }
        s.push(diff);
    }
    return s.size() + 1;
}