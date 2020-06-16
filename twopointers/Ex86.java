public class Ex86 {
    
}

class Ex86Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lp = head;
        ListNode rp;
        if (head == null)
            return head;
        while (lp.val < x && lp.next != null && lp.next.val < x)
            lp = lp.next;
        rp = lp;
        while (rp != null && rp.next != null) {
            if (rp.next.val < x) {
                ListNode tmp;
                tmp = rp.next;
                rp.next = tmp.next;
                if (lp == head && lp.val >= x) {
                    tmp.next = head;
                    head = tmp;
                    lp = tmp;
                } else {
                    tmp.next = lp.next;
                    lp.next = tmp;
                    lp = lp.next;
                }
            } else {
                rp = rp.next;
            }
        }
        return head;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}