#include <iostream>
#include <vector>

#include "test.cpp"
using namespace std;

void insertion_sort(vector<int> &array) {
    for (auto i = 1; i < array.size(); ++i) {
        int index = i - 1, key = array[i];
        while (index >= 0 && array[index] > key) {
            array[index + 1] = array[index];
            --index;
        }
        array[index + 1] = key;
    }
}

int main() {
    for (int i = 0; i < 100; ++i) {
        vector<int> vec = get_vector();
        vector<int> my_vec(vec);
        insertion_sort(my_vec);
        if (!check(vec, my_vec)) {
            cout << "failed!" << endl;
            for (auto i : my_vec) cout << i << ", ";
            cout << endl;
            return 0;
        }
    }
    cout << "success" << endl;
    return 0;
}
