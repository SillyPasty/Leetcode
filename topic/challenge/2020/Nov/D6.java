import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class D6 {
    public int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        for (int i = 0; i < bit.length; i++) {
            bit[i] = bit[i >> 1] + (i&1);
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int x : arr) {
            arrayList.add(x);
        }
        Collections.sort(arrayList, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                if (bit[a] != bit[b])
                    return bit[a] - bit[b];
                return a - b;
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }
}
