// Last updated: 13/07/2026, 23:01:11
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
12
13    private ListNode[] reverseList(ListNode head, int k)
14    {
15        ListNode curr = head;
16        ListNode prev = null, next = null;
17
18       for(int i = 0; i < k; i++){
19            next = curr.next;
20            curr.next = prev;
21            prev = curr;
22            curr = next;
23        } 
24
25        return new ListNode[] {prev, curr};
26    }
27
28    public ListNode reverseKGroup(ListNode head, int k) {
29        
30        ListNode dummy = new ListNode(0);
31        dummy.next = head;
32
33        ListNode ptr = dummy;
34
35        while(ptr != null)
36        {
37           ListNode tracker = ptr;
38
39           for(int i = 0; i < k; i++)
40           {
41            if(tracker == null) break;
42
43            tracker = tracker.next;
44           }
45
46        if (tracker == null) {
47            break;
48            }
49
50           ListNode[] reversedData = reverseList(ptr.next, k);
51
52           ListNode prev = reversedData[0];
53           ListNode curr = reversedData[1];
54
55           ListNode lastNodeOfReversedGroup = ptr.next;
56
57
58           lastNodeOfReversedGroup.next = curr;
59
60           ptr.next = prev;
61
62           ptr = lastNodeOfReversedGroup;
63           
64        }
65
66        return dummy.next;
67    }
68}