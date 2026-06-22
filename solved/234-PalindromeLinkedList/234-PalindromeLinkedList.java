// Last updated: 22/06/2026, 23:53:42
class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode copy = cloneList(head);   
        ListNode rev = reverse(copy);      
        return check(head, rev);
    }


    public ListNode cloneList(ListNode head) {
        if (head == null) return null;

        ListNode newHead = new ListNode(head.val);
        newHead.next = cloneList(head.next);
        return newHead;
    }


    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }


    public boolean check(ListNode left, ListNode right) {
        if (right == null) return true;     
        if (left.val != right.val) return false;

        return check(left.next, right.next);
    }
}
