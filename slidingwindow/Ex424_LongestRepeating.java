package slidingwindow;

public class Ex424_LongestRepeating {
    public static void main (String args[]) {
        Ex424Solution sol = new Ex424Solution();
        String s = "BAAA";
        int k = 1;
        System.out.println(sol.characterReplacement(s, k));
    }
}

class Ex424Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, max = 0;
        int cnt[] = new int[26];
        for (;end < s.length(); end++) {
            max = Math.max(max, ++cnt[s.charAt(end) - 'A']);
            while (max + k <= end - start) 
                cnt[s.charAt(start++) - 'A']--;
        }
        return s.length() - start;
    }
}