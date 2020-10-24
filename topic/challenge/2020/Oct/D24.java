
public class D24 {
    public int videoStitching(int[][] clips, int T) {
        int[] maxP = new int[T];
        int ret = 0, pre = 0, last = 0;
        for (int[] clip : clips)
            if (clip[0] < T)
                maxP[clip[0]] = Math.max(maxP[clip[0]], clip[1]);
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxP[i]);
            if (last == i)
                return -1;
            if (pre == i) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }
}
