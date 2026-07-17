// Last updated: 17/07/2026, 22:53:50
1class Solution {
2        public int minimumScore(String s, String t) {
3            int m = s.length(), n = t.length();
4            int[] left = new int[m];
5            for (int i = 0, j = 0; i < m; i++) {
6                if (j < n && s.charAt(i) == t.charAt(j)) {
7                    ++j;
8                }
9                left[i] = j;
10            }
11            int[] right = new int[m];
12            for (int i = m - 1, j = n - 1; i >= 0 ; i--) {
13                if (j >= 0 && s.charAt(i) == t.charAt(j)) {
14                    --j;
15                }
16                right[i] = j;
17            }
18            int min = Math.min(n - left[m - 1], right[0] + 1);
19            for (int i = 0; i + 1 < m; i++) {
20                min = Math.min(min, Math.max(0, right[i + 1] - left[i] + 1));
21            }
22            return min;
23        }
24    }