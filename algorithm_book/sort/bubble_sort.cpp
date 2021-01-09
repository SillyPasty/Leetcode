#include <iostream>
#include <vector>

#include "test.cpp"
using namespace std;

void bubble_sort(vector<int> &array) {
    bool flag = true;
    while (flag) {
        flag = false;
        for (int i = 0; i < array.size() - 1; ++i)
            if (array[i] > array[i + 1]) {
                swap(array[i], array[i + 1]);
                flag = true;
            }
    }
}

int main() {
    for (int i = 0; i < 100; ++i) {
        vector<int> vec = get_vector();
        vector<int> my_vec(vec);
        bubble_sort(my_vec);
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
