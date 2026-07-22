// Last updated: 22/07/2026, 08:18:38
1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        int[][] arr = new int[m][n];
6
7        for (int j = 0; j < n; j++) {
8            arr[0][j] = matrix[0][j] - '0';
9        }
10
11        for (int i = 1; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13                if (matrix[i][j] == '0') {
14                    arr[i][j] = 0;
15                } else {
16                    arr[i][j] = arr[i - 1][j] + 1;
17                }
18            }
19        }
20
21        int ans = 0;
22
23        for (int i = 0; i < m; i++) {
24            ans = Math.max(ans, MAH(arr[i]));
25        }
26
27        return ans;
28    }
29
30    public int MAH(int[] ht) {
31        int n = ht.length;
32        int[] nsl = new int[n];
33        int[] nsr = new int[n];
34        Stack<int[]> st = new Stack<>();
35
36        for (int i = 0; i < n; i++) {
37            while (!st.isEmpty() && st.peek()[0] >= ht[i])
38                st.pop();
39
40            nsl[i] = st.isEmpty() ? -1 : st.peek()[1];
41            st.push(new int[]{ht[i], i});
42        }
43
44        st.clear();
45
46        for (int i = n - 1; i >= 0; i--) {
47            while (!st.isEmpty() && st.peek()[0] >= ht[i])
48                st.pop();
49
50            nsr[i] = st.isEmpty() ? n : st.peek()[1];
51            st.push(new int[]{ht[i], i});
52        }
53
54        int ans = 0;
55
56        for (int i = 0; i < n; i++) {
57            int width = nsr[i] - nsl[i] - 1;
58            ans = Math.max(ans, width * ht[i]);
59        }
60
61        return ans;
62    }
63}