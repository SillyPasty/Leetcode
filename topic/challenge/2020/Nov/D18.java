class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int LEN = gas.length;
        int[] gainArray = new int[LEN];
        for (int i = 0; i < LEN; i++)
            gainArray[i] = gas[i] - cost[i];
        int lp = 0, rp = 0;
        int cur = 0;
        while ((rp % LEN) != lp || rp == lp) {
            int gain = gainArray[rp++ % LEN];
            cur += gain;
            if (lp > LEN)
                return -1;
            while (cur < 0) {
                cur -= gainArray[lp % LEN];
                lp++;
            }
        }
        return lp % LEN;
    }
}