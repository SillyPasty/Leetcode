package tree;

public class Ex105 {
    /**
     * Definition for a binary tree node.
     */
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

    class Solution {
        int idx = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (this.idx >= preorder.length)
                return null;
            if (inorder.length == 0)
                return null;
            int curHead = preorder[this.idx++];
            int index = 0;
            for (int i = 0; i < inorder.length; i++)
                if (inorder[i] == curHead) {
                    index = i;
                    break;
                }
            TreeNode tn = new TreeNode(curHead);
            tn.left = buildTree(preorder, Arrays.copyOfRange(inorder, 0, index));
            tn.right = buildTree(preorder, Arrays.copyOfRange(inorder, index + 1, inorder.length));
            return tn;
        }

    }
}