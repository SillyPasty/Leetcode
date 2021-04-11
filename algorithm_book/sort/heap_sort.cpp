#include <iostream>
#include <vector>

#include "test.cpp"
using namespace std;
class Heap {
public:
    Heap(int size) {
        my_heap = vector<int>(size);
        flag = -1;
    }

    void push(int val) {
        if (flag >= my_heap.size()) return;
        my_heap[flag] = val;
        int new_idx = flag++;
        int par_idx;
        while (new_idx) {
            par_idx = (new_idx - 1) / 2;
            if (my_heap[par_idx] > my_heap[new_idx])
                swap(my_heap[par_idx], my_heap[new_idx]);
            new_idx = par_idx;
        }
    }
    void pop() {
        if (flag == -1) return;
        percolage_down();
    }

    int front() {
        if (flag != -1)
            return my_heap[0];
        else
            exit(-1);
    }

private:
    vector<int> my_heap;
    int flag;
    void percolage_down() {
        int cur_val = my_heap[flag];
        --flag;
        int cur_hole = 0;
        while (1) {
            int left = 2 * cur_hole + 1;
            int right = 2 * cur_hole + 2;
            if (left > flag || (right > flag && my_heap[left] >= cur_val) ||
                (my_heap[left] >= cur_val && my_heap[right] >= cur_val)) {
                my_heap[cur_hole] = cur_val;
                break;
            } else if (my_heap[left] < cur_val) {
                my_heap[cur_hole] = my_heap[left];
                cur_hole = left;
            } else {
                my_heap[cur_hole] = my_heap[left];
                cur_hole = right;
            }
        }
    }
};