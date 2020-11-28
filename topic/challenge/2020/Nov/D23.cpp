#include <bits/stdc++.h>
using namespace std;
struct Node {
    int beg;
    int end;
};
bool cmp(Node u, Node v) {
    return u.end < v.end;
}
int findMinArrowShots(vector<vector<int>> &points) {
    if (points.empty())
        return 0;
    Node nodes[points.size()];
    for (int i = 0; i < points.size(); i++) {
        nodes[i].beg = points[i][0];
        nodes[i].end = points[i][1];
    }
    sort(&nodes[0], &nodes[points.size()], cmp);
    int flag = nodes[0].end, res = 1;
    for (auto node : nodes) {
        if (node.beg > flag) {
            ++res;
            flag = node.end;
        }
    }
    return res;
}