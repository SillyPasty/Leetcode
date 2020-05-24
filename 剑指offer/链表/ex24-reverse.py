# 递归！！
def reverseList(self, head: ListNode) -> ListNode:
        if head == None or head.next == None:
            return head
        res = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return res
    