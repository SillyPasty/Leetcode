package twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex30 {
    public static void main(String[] args) {
        Ex30Solution sol = new Ex30Solution();
        String s = "a";
        String[] words = {"a"};
        // "barfoothefoobarman";// "wordgoodgoodgoodbestword";
        // // String[] words = {"word","good","best","good"}; // "barfoofoobarthefoobarman";
        // String[] words = { "foo", "bar" , "the"};
        System.out.println(sol.findSubstring(s, words));
    }
}

class Ex30Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        Map<String, Integer> counts = new HashMap<String, Integer>();
        if (s.length() == 0 || words.length == 0)
            return result;

        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        final int n = s.length(), num = words.length, len = words[0].length();

        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                result.add(i);
            }
        }

        return result;
    }
}