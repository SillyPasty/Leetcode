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

public class D12 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode tmp = head.next;
            tmp.next = swapPairs(head.next.next);
            head.next = tmp.next;
            tmp.next = head;
            return tmp;
        }
    }
}
