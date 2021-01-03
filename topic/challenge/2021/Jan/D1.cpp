class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        if (!n) return true;
        for (int i = 0; i < flowerbed.size(); ++i) {
            if (flowerbed[i] == 1)
                continue;
            if ((i == 0 && flowerbed.size() == 1) ||
                (i == 0 && i + 1 < flowerbed.size() && flowerbed[i+1] == 0) ||
                (i == flowerbed.size()-1 && i - 1 >= 0 && flowerbed[i - 1] == 0) ||
                (i != 0 && i != flowerbed.size() - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)) {
                    --n;
                    flowerbed[i] = 1;
            }
            if (!n)
                return true;
        }
        return false;
    }
};