public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class D23 {
    public boolean isPalindrome(ListNode head) {
        ListNode p1, p2;
        p1 = head;
        p2 = head;
        if (head == null)
            return true;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p2 = reverse(p1);
        while (head != p1) {
            if (head.val != p2.val)
                return false;
            head = head.next;
            p2 = p2.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode cur, next, tmp;
        cur = head;
        next = head.next;  
        while (next != null) {
            tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        head.next = null;
        return cur;
    }
}
