# 双指针。

def getKthFromEnd(self, head: ListNode, k: int) -> ListNode:
        count = 0
        h = head
        if k == 0:
            return None

        for i in range(0, k):
            if head == None:
                return None
            head = head.next
        
        while head != None:
            h = h.next
            head = head.next
        return h