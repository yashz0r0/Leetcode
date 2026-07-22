// Last updated: 22/07/2026, 23:41:25
1import java.util.*;
2
3class Solution {
4    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
5        int n = s.length();
6        int tot = 0;
7        
8        for (int i = 0; i < n; i++) {
9            if (s.charAt(i) == '1') tot++;
10        }
11        
12        List<int[]> b = new ArrayList<>();
13        int i = 0;
14        while (i < n) {
15            if (s.charAt(i) == '0') {
16                int st = i;
17                while (i < n && s.charAt(i) == '0') i++;
18                b.add(new int[]{st, i - 1});
19            } else {
20                i++;
21            }
22        }
23        
24        int m = b.size();
25        ST st = null;
26        
27        if (m > 1) {
28            int[] g = new int[m - 1];
29            for (int j = 0; j < m - 1; j++) {
30                int l1 = b.get(j)[1] - b.get(j)[0] + 1;
31                int l2 = b.get(j + 1)[1] - b.get(j + 1)[0] + 1;
32                g[j] = l1 + l2;
33            }
34            st = new ST(g);
35        }
36        
37        List<Integer> ans = new ArrayList<>();
38        
39        for (int[] q : queries) {
40            int l = q[0], r = q[1];
41            if (m == 0) {
42                ans.add(tot);
43                continue;
44            }
45            
46            int a = -1;
47            int lo = 0, hi = m - 1;
48            while (lo <= hi) {
49                int md = lo + (hi - lo) / 2;
50                if (b.get(md)[1] >= l) {
51                    a = md;
52                    hi = md - 1;
53                } else {
54                    lo = md + 1;
55                }
56            }
57            
58            int c = -1;
59            lo = 0; hi = m - 1;
60            while (lo <= hi) {
61                int md = lo + (hi - lo) / 2;
62                if (b.get(md)[0] <= r) {
63                    c = md;
64                    lo = md + 1;
65                } else {
66                    hi = md - 1;
67                }
68            }
69            
70            if (a == -1 || c == -1 || a >= c) {
71                ans.add(tot);
72            } else {
73                int mx = 0;
74                
75                if (a + 1 == c) {
76                    int lLen = b.get(a)[1] - Math.max(l, b.get(a)[0]) + 1;
77                    int rLen = Math.min(r, b.get(c)[1]) - b.get(c)[0] + 1;
78                    mx = lLen + rLen;
79                } else {
80                    int fg = (b.get(a)[1] - Math.max(l, b.get(a)[0]) + 1) + 
81                             (b.get(a + 1)[1] - b.get(a + 1)[0] + 1);
82                    
83                    int lg = (b.get(c - 1)[1] - b.get(c - 1)[0] + 1) + 
84                             (Math.min(r, b.get(c)[1]) - b.get(c)[0] + 1);
85                    
86                    mx = Math.max(fg, lg);
87                    
88                    if (a + 1 <= c - 2) {
89                        int mg = st.query(a + 1, c - 2);
90                        mx = Math.max(mx, mg);
91                    }
92                }
93                ans.add(tot + mx);
94            }
95        }
96        return ans;
97    }
98    
99    class ST {
100        int[] t;
101        int sz;
102        
103        ST(int[] a) {
104            sz = a.length;
105            t = new int[4 * sz];
106            if (sz > 0) {
107                build(a, 0, 0, sz - 1);
108            }
109        }
110        
111        void build(int[] a, int nd, int s, int e) {
112            if (s == e) {
113                t[nd] = a[s];
114            } else {
115                int md = s + (e - s) / 2;
116                build(a, 2 * nd + 1, s, md);
117                build(a, 2 * nd + 2, md + 1, e);
118                t[nd] = Math.max(t[2 * nd + 1], t[2 * nd + 2]);
119            }
120        }
121        
122        int query(int l, int r) {
123            if (sz == 0 || l > r) return 0;
124            return query(0, 0, sz - 1, l, r);
125        }
126        
127        int query(int nd, int s, int e, int l, int r) {
128            if (r < s || e < l) return 0;
129            if (l <= s && e <= r) return t[nd];
130            int md = s + (e - s) / 2;
131            int p1 = query(2 * nd + 1, s, md, l, r);
132            int p2 = query(2 * nd + 2, md + 1, e, l, r);
133            return Math.max(p1, p2);
134        }
135    }
136}