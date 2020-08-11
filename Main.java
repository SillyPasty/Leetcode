// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Hashtable;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        int x1 = 1, x2 = 1;
        for (int i = 0; i < 100; i++) {
            hashtable.put(x2, 1);
            int tmp = x2;
            x2 = x1 + x2;
            x1 = tmp;
        }
        int n = sc.nextInt();
        int ans = 0;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            if (hashtable.getOrDefault(x, -1) == -1)
                ans += 1;
        } 
        System.out.println(ans);
    }
    public class Solution {
        public String replaceSpace(StringBuffer str) {
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == ' ')
                    sb.append("%20");
                else
                    sb.append(str.substring(i, i+1));
            }
            return sb.substring(0);
        }
    }
}