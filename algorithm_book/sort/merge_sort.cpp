#include <iostream>
#include <vector>

#include "test.cpp"
using namespace std;

void merge(vector<int> &array, int l1, int r1, int l2, int r2) {
    int lo1 = l1, lo2 = l2;
    vector<int> tmp;
    while (lo1 <= r1 && lo2 <= r2) {
        if (array[lo1] < array[lo2])
            tmp.push_back(array[lo1++]);
        else
            tmp.push_back(array[lo2++]);
    }
    while (lo1 <= r1) tmp.push_back(array[lo1++]);
    while (lo2 <= r2) tmp.push_back(array[lo2++]);
    for (int i = 0; i < tmp.size(); ++i) array[l1 + i] = tmp[i];
}

void split(vector<int> &array, int l, int r) {
    if (l >= r) return;
    int mid = (l + r) / 2;
    split(array, l, mid);
    split(array, mid + 1, r);
    merge(array, l, mid, mid + 1, r);
}

void merge_sort(vector<int> &array) {
    split(array, 0, array.size() - 1);
}

int main() {
    for (int i = 0; i < 1000; ++i) {
        vector<int> vec = get_vector();
        vector<int> my_vec(vec);
        merge_sort(my_vec);
        if (!check(vec, my_vec)) {
            cout << "failed!" << endl;
            for (auto i : my_vec) cout << i << ", ";
            cout << endl;
            for (auto i : vec) cout << i << ", ";
            cout << endl;
            return 0;
        }
    }
    cout << "success" << endl;
    return 0;
}
