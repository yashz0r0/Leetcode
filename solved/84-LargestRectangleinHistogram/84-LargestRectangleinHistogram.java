// Last updated: 21/07/2026, 13:16:52
1class Solution {
2    public int largestRectangleArea(int[] ht) {
3        int n = ht.length;
4        int[] nsl = new int[n];
5        int[] nsr = new int[n];
6        Stack<int[]> st = new Stack<>();
7
8        for (int i = 0; i < n; i++) {
9            while (!st.isEmpty() && st.peek()[0] >= ht[i])
10                st.pop();
11
12            nsl[i] = st.isEmpty() ? -1 : st.peek()[1];
13
14            st.push(new int[]{ht[i], i});
15        }
16
17        st.clear();
18
19        for (int i = n - 1; i >= 0; i--) {
20            while (!st.isEmpty() && st.peek()[0] >= ht[i])
21                st.pop();
22
23            nsr[i] = st.isEmpty() ? n : st.peek()[1];
24
25            st.push(new int[]{ht[i], i});
26        }
27
28        int ans = 0;
29
30        for (int i = 0; i < n; i++) {
31            int width = nsr[i] - nsl[i] - 1;
32            ans = Math.max(ans, width * ht[i]);
33        }
34
35        return ans;
36    }
37}