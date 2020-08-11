import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String args[]) {
        // Solution sol = new Solution();
        // String s = new String("a");
        // System.out.println(sol.lengthOfLongestSubstring(s));
        Scanner s = new Scanner(System.in);
        // Arrays.sort(a[], (o1, o2) -> o1 - o2);
        ArrayList<Integer> a = new ArrayList<Integer>();
        Stack<Integer> sta = new Stack<>();
        sta.push(1);
        sta.pop();
        Queue<Integer> queue = new Queue<Integer>();
        queue.add(1);
        queue.poll();
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            System.out.println(x + y);
        }
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0, lc = 0;
        HashMap<Character,Integer> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int tmp = hash.getOrDefault(c, -1);
            if(tmp != -1 && tmp >= lc)
                lc = tmp + 1;
            hash.put(c, i);
            result = Math.max(i - lc + 1, result);
        }
        return result;
    }
    // public class PriorityQueueTest {

    //     public static void test(String[] args) {
    //         Queue<Integer> queue1 = new PriorityQueue<Integer>();
    //         queue1.add(2);
    //         queue1.add(1);
    //         queue1.add(3);

    //         while (!queue1.isEmpty()) {
    //             Integer i = queue1.poll();
    //             System.out.println(i);
    //         }
    
    //         Comparator<Student> comparator = new Comparator<Student>() {
    //             @Override
    //             public int compare(Student o1, Student o2) {
    //                 return (o1.id - o2.id);
    //             }
    //         };
    
    //         Queue<Student> queue2 = new PriorityQueue<Student>(comparator);
    //         queue2.add(new Student(2, "B"));
    //         queue2.add(new Student(1, "A"));
    //         queue2.add(new Student(3, "C"));
    
    //         while (!queue2.isEmpty()) {
    //             Student s = queue2.poll();
    //             System.out.println(s.toString());
    //         }
    //     }
    
    //     public static class Student {
    //         private int id;
    //         private String name;
    
    //         public Student(int id, String name) {
    //             this.id = id;
    //             this.name = name;
    //         }
    
    //         public String toString() {
    //             return id + "-" + name;
    //         }
    //     }
    // }
}