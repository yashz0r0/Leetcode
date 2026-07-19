// Last updated: 19/07/2026, 19:27:05
1class Solution {
2    public int[] nextGreaterElements(int[] nums) {
3        Stack<Integer> st = new Stack<>();
4
5        int n = nums.length;
6        int[] nums2 = new int[2 * n];
7
8        for (int i = 0; i < n; i++) {
9            nums2[i] = nums[i];
10            nums2[i + n] = nums[i];
11        }
12
13        int[] nge = new int[2 * n];
14        Arrays.fill(nge, -1);
15
16        for (int i = nums2.length - 1; i >= 0; i--) {
17            while (!st.isEmpty() && st.peek() <= nums2[i]) {
18                st.pop();
19            }
20
21            if (!st.isEmpty())
22                nge[i] = st.peek();
23
24            st.push(nums2[i]);
25        }
26
27        int[] res = new int[n];
28        for (int i = 0; i < n; i++) {
29            res[i] = nge[i];
30        }
31
32        return res;
33    }
34}