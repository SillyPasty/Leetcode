# 根据递归顺序，有更好解法，不用搜索

"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""
class Solution:
    def treeToDoublyList(self, root: 'Node') -> 'Node':
        if not root:
            return root
        
        def getPre(node):
            if not node.left:
                return node
            node = node.left
            while node.right:
                node = node.right
            return node
        
        def getAft(node):
            if not node.right:
                return node
            node = node.right
            while node.left:
                node = node.left
            return node

        def conn(node):
            preN = getPre(node)
            posN = getAft(node)
            if preN != node:
                node.left = preN
                preN.right = node
            if posN != node:
                node.right = posN
                posN.left = node
        
        def tra(node):
            if not node:
                return
            tra(node.left)
            tra(node.right)
            conn(node)
        
        head = root
        while head.left:
            head = head.left
        tail = root
        while tail.right:
            tail = tail.right
        tra(root)
        head.left = tail
        tail.right = head

        return head
