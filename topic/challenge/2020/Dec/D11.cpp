#include <list>
#include <string>
#include <vector>
using namespace std;
string predictPartyVictory(string senate) {
    list<int> r, d;
    vector<bool> is_visit(senate.size(), true);
    for (int i = 0; i < senate.size(); ++i)
        if (senate[i] == 'R')
            r.push_back(i);
        else
            d.push_back(i);
    while (r.size() && d.size()) {
        if (r.front() < d.front())
            r.push_back(r.front() + senate.size());
        else
            d.push_back(d.front() + senate.size());
        r.pop_front();
        d.pop_front();
    }
    return !r.size() ? "Dire" : "Radiant";
}