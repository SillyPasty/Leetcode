class ListNode {
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
    public ListNode oddEvenList(ListNode head) {
        ListNode a, b, c;
        ListNode oHead, eHead;
        int cnt = 0;
        oHead = head;
        if (oHead == null) {
            return oHead;
        }
        eHead = head.next;
        if (eHead == null) {
            return oHead;
        }
        a = head;
        b = head.next;
        c = b.next;
        while (c != null) {
            a.next = c;
            a = b;
            b = c;
            c = c.next;
            cnt++;
        }
        if (cnt % 2 == 0) {
            a.next = eHead;
            b.next = null;
        } else {
            a.next = null;
            b.next = eHead;
        }
        return oHead;
    }
}