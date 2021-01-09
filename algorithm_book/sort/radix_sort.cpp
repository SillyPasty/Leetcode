#include <iostream>
#include <vector>

#include "test.cpp"
using namespace std;

void radix_sort(vector<int> &array) {
    int max_num = array[0];
    for (auto i : array) max_num = max(i, max_num);
    vector<int> radix(max_num + 1);
    for (auto i : array) ++radix[i];
    int index = 0;
    for (auto i = 0; i <= max_num; ++i)
        while (radix[i]--) array[index++] = i;
}

int main() {
    for (int i = 0; i < 100; ++i) {
        vector<int> vec = get_vector();
        vector<int> my_vec(vec);
        radix_sort(my_vec);
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
