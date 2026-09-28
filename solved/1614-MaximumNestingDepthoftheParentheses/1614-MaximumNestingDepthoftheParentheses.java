// Last updated: 28/09/2026, 23:17:27
1class Solution {
2    public int maxDepth(String s) {
3        int depth = 0;
4        int r = 0;
5        for (char c : s.toCharArray()) {
6            if (c == ')') {
7                depth--;
8                continue;
9            }
10           
11            if (c != '(') continue;
12            depth++;
13            if (depth > r) r = depth;
14        }
15        return r;
16    }
17}