#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        queue<TreeNode*> q;
        vector<vector<int>> res;
        if (!root) return res;
        q.push(root);
        int level = 0;
        while (q.size()) {
            queue<TreeNode*> tmp;
            vector<int> res_v;
            while (!q.empty()) {
                TreeNode* cur = q.front();
                q.pop();
                res_v.push_back(cur->val);
                if (cur->left) tmp.push(cur->left);
                if (cur->right) tmp.push(cur->right);
            }
            q = tmp;
            if (level % 2) reverse(res_v.begin(), res_v.end());
            ++level;
            res.push_back(res_v);
        }
        return res;
    }
};