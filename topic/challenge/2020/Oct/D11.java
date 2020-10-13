import java.io.InputStream;
import java.lang.module.Configuration;
import java.util.ArrayList;

public class D11 {
    class Solution {
        ArrayList<Integer> list = new ArrayList<>();
        public int getMinimumDifference(TreeNode root) {
            tra(root);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size() - 1; i++)
                min = Math.min(list.get(i + 1) - list.get(i), min);
            return min;
        }
        public void tra(TreeNode node) {
            if (node == null)
                return;
            tra(node.left);
            list.add(node.val);
            tra(node.right);
        }
    }
}
