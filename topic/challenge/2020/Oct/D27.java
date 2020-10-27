import java.util.ArrayList;
import java.util.List;

public class D27 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        pre(root, res);
        return res;
    }

    public void pre(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        res.add(node.val);
        pre(node.left, res);
        pre(node.right, res);
    }
}
