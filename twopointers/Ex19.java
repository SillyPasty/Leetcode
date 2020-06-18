package twopointers;

public class Ex19 {

}

// class Ex19Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode rp = head, lp = head;
//         for (int i = 0; i < n; i++)
//             rp = rp.next;
//         if (rp == null)
//             return head.next;
//         while (rp.next != null) {
//             lp = lp.next;
//             rp = rp.next;
//         }
//         lp.next = lp.next.next;
//         return head;
//     }
// }