#include <iostream>
#include <vector>

#include "test.cpp"
using namespace std;

int choose_swap(vector<int> &array, int l, int r) {
    int flag = array[l];
    swap(array[l], array[r]);
    int lo = l, hi = r - 1;
    while (lo < hi) {
        while (array[lo] <= flag && lo <= hi) ++lo;
        while (array[hi] > flag && lo < hi) --hi;
        if (lo >= hi) break;
        swap(array[lo], array[hi]);
    }
    swap(array[r], array[lo]);
    return lo;
}

void partition(vector<int> &array, int l, int r) {
    if (l + 1 == r) {
        if (array[l] > array[r]) swap(array[l], array[r]);
        return;
    }
    if (l >= r) return;
    int part_point = choose_swap(array, l, r);
    partition(array, l, part_point - 1);
    partition(array, part_point + 1, r);
}

void quick_sort(vector<int> &array) {
    partition(array, 0, array.size() - 1);
}

int main() {
    for (int i = 0; i < 100; ++i) {
        vector<int> vec = get_vector();
        vector<int> my_vec(vec);
        quick_sort(my_vec);
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
