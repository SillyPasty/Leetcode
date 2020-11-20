public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        int idx = 1;
        if (head == null || head.next == null)
            return head;
        ListNode cur = head.next;
        ListNode curPrev = head;
        while (cur != null) {
            int val = cur.val;
            ListNode tmp = head;
            ListNode tmpPrev = null;
            ListNode next = cur.next;
            for (int i = 0; i < idx; i++) {
                if (tmp == null || tmp.val > val) {
                    break;
                }
                tmpPrev = tmp;
                tmp = tmp.next;
            }
            if (tmp == cur) {
                cur = cur.next;
                curPrev = curPrev.next;
            } else if (tmp == head) {
                curPrev.next = cur.next;
                cur.next = tmp;
                head = cur;
                cur = next;
            } else {
                curPrev.next = cur.next;
                cur.next = tmpPrev.next;
                tmpPrev.next = cur;
                cur = next;
            }
            idx++;
            ListNode tra = head;
        }
        return head;
    }
}