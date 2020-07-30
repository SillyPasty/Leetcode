package tree;

public class Ex124 {
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
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null)
                return 0;
            getMax(root);
            return this.max;
        }

        private int getMax(TreeNode curNode) {
            if (curNode == null)
                return 0;
            int leftMax = getMax(curNode.left);
            int rightMax = getMax(curNode.right);
            int childMax = Math.max(0, 
                Math.max(leftMax, rightMax));
            this.max = Math.max(childMax + curNode.val, this.max);
            this.max = Math.max(leftMax + rightMax + curNode.val, this.max);
            
            return childMax + curNode.val;
        }
    }
}