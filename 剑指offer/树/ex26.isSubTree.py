 def isSubStructure(self, A: TreeNode, B: TreeNode) -> bool:
        if B == None or A == None:
            return False
        res = self.isSubTree(A, B)
        if res == False:
            res = self.isSubStructure(A.left, B) or self.isSubStructure(A.right, B)
        return res
        
        
def isSubTree(self, A, B):
    if B == None:
        return True
    if A == None:
        return False
    if A.val != B.val:
        return False
    return self.isSubTree(A.left, B.left) and self.isSubTree(A.right, B.right)