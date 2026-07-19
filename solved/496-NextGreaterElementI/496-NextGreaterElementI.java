// Last updated: 19/07/2026, 18:04:11
1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        Stack<Integer> st = new Stack<>();
4        Map<Integer, Integer> map = new HashMap<>();
5
6        for (int i = nums2.length - 1; i >= 0; i--) {
7            while (!st.isEmpty() && st.peek() <= nums2[i]) {
8                st.pop();
9            }
10
11            if (st.isEmpty())
12                map.put(nums2[i], -1);
13            else
14                map.put(nums2[i], st.peek());
15
16            st.push(nums2[i]);
17        }
18
19        int[] res = new int[nums1.length];
20        for (int i = 0; i < nums1.length; i++) {
21            res[i] = map.get(nums1[i]);
22        }
23
24        return res;
25    }
26}