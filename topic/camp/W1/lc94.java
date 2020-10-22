import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class lc94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inOrderTraverse(res, root);
        return res;
    }
    public void inOrderTraverse(List<Integer> lis, TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(lis, node.left);
        lis.add(node.val);
        inOrderTraverse(lis, node.right);
    }
}
