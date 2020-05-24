# 分治！
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        def copy():
            node = head
            while node:
                newNode = Node(node.val, node.next)
                node.next = newNode
                node = newNode.next
        def conn():
            node = head
            while node:
                if node.random:
                    node.next.random = node.random.next
                else:
                    node.next.random = None
                node = node.next.next
    
        def extra():
            node = head.next
            while node.next:
                node.next = node.next.next
                node = node.next
        copy()
        conn()
        extra()

        return head.next