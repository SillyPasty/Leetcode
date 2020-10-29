package topic.challenge.2020.Oct;

public class D29 {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        pre(root, 0);
        return result;
    }

    public void pre(TreeNode tn, int cur) {
        if (tn == null)
            return;
        cur = cur * 10 + tn.val;
        if (tn.left == null && tn.right == null) {
            result += cur;
            return;
        }
        pre(tn.left, cur);
        pre(tn.right, cur);
    }
}
