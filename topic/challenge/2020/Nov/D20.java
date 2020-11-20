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
        ListNode cur = head;
        ListNode curPrev = head;
        if (head == null || head.next == null)
            return head;
        while (cur != null) {
            int val = cur.val;
            ListNode tmp = head;
            ListNode tmpPrev = head;
            ListNode next = cur.next;
            for (int i = 0; i < idx; i++) {
                if (tmp.val > val) {
                    break;
                } else {
                    tmpPrev = tmp;
                    tmp = tmp.next;
                }
            }
            if (tmp == head) {
                curPrev.next = cur.next;
                cur.next = tmp;
                head = cur;
                cur = next;
            } else {
                curPrev.next = cur.next;
                cur.next = tmp;
                tmpPrev.next = cur;
                cur = next;
            }
            idx++;
        }
        return head;
    }
}