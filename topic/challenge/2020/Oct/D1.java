import java.util.ArrayList;

class RecentCounter {
    ArrayList<Integer> array = new ArrayList<Integer>();
    int cur, idx;
    public RecentCounter() {
        idx = 0;
        cur = 0;
    }
    
    public int ping(int t) {
        array.add(t);
        cur++;
        while (idx != array.size() && t - 3000 > array.get(idx)) {
            idx++;
            cur--;
        }
        return cur;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */