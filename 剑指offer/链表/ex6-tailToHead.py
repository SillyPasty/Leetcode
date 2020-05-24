# 注意类内递归要加self
# 关注输入和输出的顺序 后进先出：栈
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reversePrint(self, head: ListNode):
        if head == None:
            return []
        if head.next == None:
            return [head.val]
        return self.reversePrint(head.next) + [head.val]

