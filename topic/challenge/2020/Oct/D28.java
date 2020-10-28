import java.util.HashMap;
import java.util.Map;

public class D28 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i, 1 + map.getOrDefault(i, 0));
        HashMap<Integer, Boolean> check = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (check.getOrDefault(entry.getValue(), false) == false)
                check.put(entry.getValue(), true);
            else
                return false;
        }
        return true;
    }
}
