#include <iostream>
#include <vector>

#include "test.cpp"
using namespace std;

void selection_sort(vector<int> &array) {
    for (auto i = 0; i < array.size(); ++i) {
        int max_idx = i;
        for (auto j = i; j < array.size(); ++j)
            max_idx = array[j] < array[max_idx] ? j : max_idx;
        swap(array[max_idx], array[i]);
    }
}

int main() {
    for (int i = 0; i < 100; ++i) {
        vector<int> vec = get_vector();
        vector<int> my_vec(vec);
        selection_sort(my_vec);
        if (!check(vec, my_vec)) {
            cout << "failed!" << endl;
            for (auto i : vec) cout << i << ", ";
            cout << endl;
            return 0;
        }
    }
    cout << "success" << endl;
    return 0;
}
