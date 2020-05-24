# 注意负值！！！
#  Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        path = []
        cursum = 0
        resList = []

        def traver(node, sum, cursum, resList, path):
            if not node:
                return
            cursum += node.val
            if cursum == sum and not (node.left or node.right):
                path += [node.val]
                resList.append(path)
            else:
                path += [node.val]
                traver(node.left, sum, cursum, resList, path[:])
                traver(node.right, sum, cursum, resList, path[:])
            return
        traver(root, sum, cursum, resList, path)
        return resList

    def pathSum2(self, root: TreeNode, sum: int) -> List[List[int]]:
        path = []
        resList = []

        def traver(node, sum):
            if not node:
                return
            sum -= node.val
            path.append(node.val)
            if not sum and not (node.left or node.right):
                resList.append(path[:])
            traver(node.left, sum)
            traver(node.right, sum)
            path.pop()
        traver(root, sum)
        return resList