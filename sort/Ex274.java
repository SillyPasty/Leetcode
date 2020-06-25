package sort;

public class Ex274 {
    public static void main (String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(new Ex274().hIndex(citations));
    } 
    public int hIndex(int[] citations) {
        // use bucket sort to gain O(N) time complexity.
        final int len = citations.length;
        int[] bucket = new int[len + 1];
        for (int i: citations)
            if (i < len) bucket[i]++;
            else bucket[len]++;
        int cnt = 0;
        for (int i = len; i >= 0; i--) {
            cnt += bucket[i];
            if (cnt >= i)
                return i;
        }
        return 0;
    }
}