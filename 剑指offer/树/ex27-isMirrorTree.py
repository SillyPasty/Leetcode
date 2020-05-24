# 代码复用, 画图！
def isSymmetric(self, root: TreeNode) -> bool:
        return self.traverse(root, root)
        
def traverse(self, root1, root2):
    if root1 == None and root2 == None:
        return True
    if root1 == None or root2 == None:
        return False
    if root1.val != root2.val:
        return False
    return self.traverse(root1.left, root2.right) and self.traverse(root1.right, root2.left)
        