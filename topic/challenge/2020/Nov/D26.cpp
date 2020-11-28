#include <bits/stdc++.h>
using namespace std;
struct Bucket {
    int minv;
    int maxv;
    int count;
    Bucket(int min_ = std::numeric_limits<int>::min(),
           int max_ = std::numeric_limits<int>::max(), int count_ = 0) {
        minv = min_;
        maxv = max_;
        count = count_;
    }
};

class Solution {
public:
    int maximumGap(vector<int>& nums) {
        // 使用桶排序;
        int num_len = nums.size();
        if (num_len <= 1)
            return 0;
        long maxv = std::numeric_limits<int>::min();
        long minv = std::numeric_limits<int>::max();
        for (int x : nums) {
            if (x < minv)
                minv = x;
            if (x > maxv)
                maxv = x;
        }
        // 求出桶的最大size
        // (maxv-minv) / (num_len-1) 表示间隔的平均值，为桶的最大size
        int bucketSize = std::max(long(1), (maxv - minv) / (num_len - 1));
        // int bucketSize = (maxv-minv) / num_len + 1;
        int numBucket = (maxv - minv) / bucketSize + 1;
        Bucket buckets[numBucket];  //  使用可变长度的数组;

        for (int x : nums) {
            int id = (x - minv) / bucketSize;
            if (buckets[id].count == 0) {
                buckets[id].maxv = buckets[id].minv = x;
            } else {
                if (x > buckets[id].maxv)
                    buckets[id].maxv = x;
                if (x < buckets[id].minv)
                    buckets[id].minv = x;
            }
            buckets[id].count++;
        }
        int prev = minv, max_gap = -1;
        for (auto& b : buckets) {
            if (b.count == 0)
                continue;
            if (b.minv - prev > max_gap)
                max_gap = b.minv - prev;
            prev = b.maxv;
        }
        return max_gap;
    }
};