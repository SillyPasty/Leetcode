bool containsDuplicate(vector<int>& nums) {
    unordered_set<int> bucket;
    for (auto num : nums) {
        if (bucket.find(num) != bucket.end()) return true;
        bucket.insert(num);
    }
    return false;
}