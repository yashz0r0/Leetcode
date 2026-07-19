// Last updated: 19/07/2026, 22:44:55
1class Solution {
2    public int longestValidParentheses(String s) {
3        int n = s.length();
4        Stack<Integer> st = new Stack<>();
5        boolean[] isval = new boolean[n];
6
7        for (int i = 0; i < n; i++) {
8            if (s.charAt(i) == '(') {
9                st.push(i);
10            } else {
11                if (st.isEmpty()) continue;
12                isval[i] = true;
13                isval[st.pop()] = true;
14            }
15        }
16
17        int ans = 0;
18        int i = 0;
19        while (i < n) {
20            if (isval[i]) {
21                int j = i;
22                while (j < n && isval[j]) {
23                    j++;
24                }
25                ans = Math.max(ans, j - i);
26                i = j;
27            }
28            i++;
29        }
30
31        return ans;
32    }
33}