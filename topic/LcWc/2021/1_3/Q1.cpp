#include <algorithm>
#include <vector>
using namespace std;

int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        sort(boxTypes.begin(), boxTypes.end(), [](vector<int> &v1, vector<int> &v2) {
            return (v2[1] < v1[1]);
        });
        int result = 0;
        for (auto box : boxTypes) {
            if (!truckSize)
                break;
            if (truckSize > box[0]) {
                result += box[0] * box[1];
                truckSize -= box[0];
            } else {
                result += truckSize * box[1];
                break;
            }
        }
        return result;
    }