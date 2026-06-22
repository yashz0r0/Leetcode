// Last updated: 22/06/2026, 23:54:14
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
    public boolean hasCycle(ListNode head) {
        return detect(head, head);
    }

    public boolean detect(ListNode s, ListNode f){
        if(f==null || f.next==null)return false;
        s=s.next;
        f=f.next.next;

        if(s==f)return true;

        return detect(s,f);
    }
}