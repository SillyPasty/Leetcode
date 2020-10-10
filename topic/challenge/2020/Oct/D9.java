class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class D9 {
    int idx = 0;
    String str;

    public static void main(String[] args) {
        String s = "null";
        s.strip();
        String[] sl = s.split(" ");
        System.out.println(sl.length);
        for (String s1 : sl)
            System.out.println(s1 == "null");
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        str = "";
        inorderTraverse(root);
        return str;
    }

    public void inorderTraverse(TreeNode node) {
        if (node == null) {
            str += "null ";
            return;
        }
        str += Integer.toString(node.val);
        str += " ";
        inorderTraverse(node.left);
        inorderTraverse(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data.strip();
        String[] sList = data.split(" ");
        if (sList.length == 1 && sList[0] == "null")
            return null;
        int cur = Integer.parseInt(sList[idx++]);
        TreeNode root = new TreeNode(cur);
        rebuild(root, sList);
        return root;
    }

    public void rebuild(TreeNode curN, String[] sList) {
        if (idx == sList.length)
            return;
        if (sList[idx] == "null") {
            idx++;
        } else {
            int cur = Integer.parseInt(sList[idx]);
            TreeNode nn = new TreeNode(cur);
            curN.left = nn;
            idx++;
            rebuild(curN.left, sList);
        }
        if (idx == sList.length)
            return;
        if (sList[idx] == "null") {
            idx++;
        } else {
            int cur = Integer.parseInt(sList[idx]);
            TreeNode nn = new TreeNode(cur);
            curN.right = nn;
            idx++;
            rebuild(curN.right, sList);
        }
        return;
    }
}
