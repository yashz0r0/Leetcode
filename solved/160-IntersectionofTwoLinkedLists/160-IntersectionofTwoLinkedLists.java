// Last updated: 17/11/2026, 21:13:04
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
14        if(headA==null || headB==null)return null;
15        
16        ListNode a= headA;
17        ListNode b= headB;
18
19        while(a!=b){
20            a=a==null?headB: a.next;
21            b=b==null?headA: b.next;
22        }
23        return b;
24    }
25}