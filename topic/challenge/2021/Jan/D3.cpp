/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode small_h(-1), big_h(-1);
        ListNode *small_cur = &small_h, *big_cur = &big_h;
        while (head != nullptr) {
            if (head->val < x) {
                small_cur->next = head;
                small_cur = head; 
            } else {
                big_cur->next = head;
                big_cur = head;
            }
            head = head->next;
        }
        small_cur -> next = big_h.next;
        big_cur->next = nullptr;
        return small_h.next;
    }
};