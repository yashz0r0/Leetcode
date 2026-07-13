// Last updated: 13/07/2026, 22:49:28
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
12    public ListNode mergeKLists(ListNode[] lists) {
13        if (lists == null || lists.length == 0) {
14            return null;
15        }
16
17        while (lists.length > 1) {
18            List<ListNode> temp = new ArrayList<>();
19            for (int i = 0; i < lists.length; i += 2) {
20                ListNode l1 = lists[i];
21                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null;
22                temp.add(mergeLists(l1, l2));
23            }
24            lists = temp.toArray(new ListNode[0]);
25        }
26
27        return lists[0];        
28    }
29
30    private ListNode mergeLists(ListNode l1, ListNode l2) {
31        ListNode node = new ListNode();
32        ListNode ans = node;
33
34        while (l1 != null && l2 != null) {
35            if (l1.val > l2.val) {
36                node.next = l2;
37                l2 = l2.next;
38            } else {
39                node.next = l1;
40                l1 = l1.next;
41            }
42            node = node.next;
43        }
44
45        node.next = l1 != null ? l1 : l2;
46        return ans.next;
47    }    
48}