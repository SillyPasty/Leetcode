package twopointers;

public class Ex142 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // ez
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head, p2 = head, p3 = null;
        while (p1 != null && p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p3 = head;
                break;
            }
        }
        while (p3 != null && p3 != p1) {
            p3 = p3.next;
            p1 = p1.next;
        }
        return p3;
    }
}
