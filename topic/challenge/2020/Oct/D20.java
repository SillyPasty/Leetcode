
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

public class D20 {
    ListNode con = null;
    int len = 0;
    public void reorderList(ListNode head) {
        ListNode tmp = head;
        if (head == null)
            return;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        tmp = head;
        for (int i = 0; i < len / 2 - 1; i++)
            tmp = tmp.next;
        if (len % 2 == 1)
            tmp = tmp.next;
    
        con = tmp.next;
        tmp.next = null;
        stack(head);
    }

    public void stack(ListNode cur) {
        if (((len % 2 == 1) && cur.next == null) || cur == null)
            return;
        stack(cur.next);
        ListNode tmp = con.next;
        con.next = cur.next;
        cur.next = con;
        con = tmp;
    }
}
