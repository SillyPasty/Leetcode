import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class D22 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            
        }
        for (int i = 0; i < s.length(); i++) {
            Character c2 = t.charAt(i);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
            if (map.get(c2) < 0) {
                return false;
            }
        }
        // for (Map.Entry<Character, Integer> entry :map.entrySet()) {
        //     if (entry.getValue() != 0)
        //         return false;
        // }
        return true;
    }
}
