/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sumList = new ListNode(0);
        ListNode head = sumList;
        int carry = 0, s = 0;

        while(l1 != null && l2 != null) {
            
            s = l1.val + l2.val + carry;
            
            carry = s / 10;
            s = s % 10;  
            
            sumList.next = new ListNode(s);
            sumList = sumList.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l2 != null) {
            s = carry + l2.val;
            carry = s / 10;
            s = s % 10;
            sumList.next = new ListNode(s);
            sumList = sumList.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            s = carry + l1.val;
            carry = s / 10;
            s = s % 10;
            sumList.next = new ListNode(s);
            sumList = sumList.next;
            l1 = l1.next;
        }

        if(carry > 0) {
            sumList.next = new ListNode(carry);
        }

        return head.next;
    }
}