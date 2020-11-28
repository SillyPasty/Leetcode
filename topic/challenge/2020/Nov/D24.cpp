#include <bits/stdc++.h>
using namespace std;
int countNodes(TreeNode* root) {
    if (!root)
        return 0;
    int tmp = 1;
    tmp += countNodes(root->left);
    tmp += countNodes(root->right);
    return tmp;
}