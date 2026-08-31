// Last updated: 31/08/2026, 21:37:02
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public int[] nodesBetweenCriticalPoints(ListNode head) {
13        int first = -1;
14        int last = -1;
15        int count = 0;
16        int idx = 1;
17        int min = Integer.MAX_VALUE;
18        ListNode prev = head;
19        ListNode curr = head.next;
20        while(curr.next != null) {
21            if((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
22                if(first == -1) {
23                    first = idx;
24                    last = idx;
25                }
26                else {
27                    min = Math.min(min,idx-last);
28                    last = idx;
29                }
30            }
31            prev = curr;
32            curr = curr.next;
33            idx++;
34        }
35        if(first == last) {
36            return new int[]{-1,-1};
37        }
38        return new int[]{min,last-first};
39    }
40}