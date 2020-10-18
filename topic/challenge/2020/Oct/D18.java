
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode n1 = head, n2 = head;
        for (int i = 0; i < n; i++)
            n1 = n1.next;
        while (n1 != null && n1.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        if (n2 == head && n1 == null)
            return n2.next;
        n2.next = n2.next.next;
        return head;
    }
}
