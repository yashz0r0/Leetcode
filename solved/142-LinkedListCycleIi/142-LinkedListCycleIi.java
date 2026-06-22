// Last updated: 22/06/2026, 23:54:12
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       ListNode s= head;
       ListNode f=head;
       while(f!=null && f.next!=null){
        s=s.next;
        f=f.next.next;

        if(s==f){
            ListNode ptr= head;

            while(ptr!=s){
                ptr=ptr.next;
                s=s.next;
            }

            return ptr;
        }
       } 

       return null;
    }
}