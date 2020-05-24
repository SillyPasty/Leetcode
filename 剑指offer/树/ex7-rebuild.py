# Definition for a binary tree node.
# 左子树、右子树，想好递归基
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None
        if len(preorder) == 1:
            return TreeNode(preorder[0])
        root = TreeNode(preorder[0])
        idx = inorder.index(root.val)
        preIdx = len(inorder[0:idx])
        root.left = self.buildTree(preorder[1:preIdx+1], inorder[0:idx])
        root.right = self.buildTree(preorder[preIdx+1:], inorder[idx+1:])
        return root
