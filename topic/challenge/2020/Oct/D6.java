// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

public class D6 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode tn = new TreeNode(val);
        if (root == null)
            return tn;
        TreeNode tmp = root;
        while(true) {
            if (val <= tmp.val) {
                if (tmp.left == null) {
                    tmp.left = tn;
                    break;
                }
                tmp = tmp.left;
            } else {
                if (tmp.right == null) {
                    tmp.right = tn;
                    break;
                }
                tmp = tmp.right;
            }
        }
        return root;
    }
}
