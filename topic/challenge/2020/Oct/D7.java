
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

public class D7 {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        if (len == 0)
            return null;
        k %= len;
        ListNode mv = head;
        tmp = head;
        for (int i = 0; i < k; i++)
            tmp = tmp.next;
        while (tmp.next != null) {
            tmp = tmp.next;
            mv = mv.next;
        }
        tmp.next = head;
        tmp = mv.next;
        mv.next = null;
        return tmp;        
    }
}
