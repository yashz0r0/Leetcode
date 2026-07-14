// Last updated: 15/07/2026, 00:33:13
1class Solution {
2     static public int[] permute(int n, long k) {
3        if (n == 1) return one(n, k);
4        if (n == 2) return two(n, k);
5        if (n == 3) return three(n, k);
6        if (n == 4) return four(n, k);
7
8        long x = 1, pro = 2;
9        long[] arr = new long[n];
10        int idx = n - 4;
11        arr[n - 3] = 1;
12        for (int i = 1; i < 23 && i < n - 2; i += 1) {
13            x = x * pro;
14            arr[idx--] = x;
15            if (i % 2 == 0) pro++;
16        }
17
18        ArrayList<Integer> odd = new ArrayList<>();
19        ArrayList<Integer> even = new ArrayList<>();
20        for (int i = 1; i <= n; i++) {
21            if (i % 2 == 1) odd.add(i);
22            else even.add(i);
23        }
24
25        if (arr[0] > 0) {
26            if (n % 2 == 0) {
27                if ((odd.size() * 2) * arr[0] < k) return new int[] {};
28            } else 
29                if (odd.size() * arr[0] < k) return new int[] {};
30            
31        }
32        int[] res = new int[n];
33        idx = 0;
34        int firstOdd = solve(n, k, arr[0]);
35        if(arr[0] == 0) firstOdd = 1000;
36        if (n % 2 == 1 || (firstOdd < 0 || firstOdd == 1000)) {
37            for (int i = 0; i < n - 3; i++) {
38                if (i % 2 == 0) {
39                    if (arr[i] == 0) {
40                        res[idx++] = odd.get(0);
41                        odd.remove(0);
42                    } else {
43                        int index = index(odd, arr[i], k);
44                        if(n % 2 == 0){
45                            if(i == 0) index = -firstOdd;
46                            if(index == -1000) index = 0;
47                        }
48                        res[idx++] = odd.get(index);
49                        odd.remove(index);
50                    }
51                } else {
52                    if (arr[i] == 0) {
53                        res[idx++] = even.get(0);
54                        even.remove(0);
55                    } else {
56                        int index = index(even, arr[i], k);
57                        res[idx++] = even.get(index);
58                        even.remove(index);
59                    }
60                }
61            }
62        } else {
63            for (int i = 0; i < n - 3; i++) {
64                if (i % 2 == 1) {
65                    if (arr[i] == 0) {
66                        res[idx++] = odd.get(0);
67                        odd.remove(0);
68                    } else {
69                        int index = index(odd, arr[i], k);
70                        res[idx++] = odd.get(index);
71                        odd.remove(index);
72                    }
73                } else {
74                    if (arr[i] == 0) {
75                        res[idx++] = even.get(0);
76                        even.remove(0);
77                    } else {
78                        int index = index(even, arr[i], k);
79                        if (firstOdd >= 0) {
80                            if (i == 0) index = firstOdd;
81                        }
82                        res[idx++] = even.get(index);
83                        even.remove(index);
84                    }
85                }
86            }
87        }
88
89        if (n % 2 == 0 && (firstOdd < 0 || firstOdd == 1000)) {
90            if (k % 2 == 0) {
91                res[n - 1] = even.get(0);
92                res[n - 3] = even.get(1);
93            } else {
94                res[n - 3] = even.get(0);
95                res[n - 1] = even.get(1);
96            }
97            res[n - 2] = odd.get(0);
98        }
99        if (n % 2 == 1 || (firstOdd >= 0 && firstOdd != 1000)) {
100            if (k % 2 == 0) {
101                res[n - 1] = odd.get(0);
102                res[n - 3] = odd.get(1);
103            } else {
104                res[n - 3] = odd.get(0);
105                res[n - 1] = odd.get(1);
106            }
107            res[n - 2] = even.get(0);
108        }
109
110        return res;
111    }
112
113    static int solve(int n, long k, long corresponds) {
114        long temp = 0;
115        int x = 0, y = 0;
116        for (int i = 0; i < 2 * n; i++) {
117            temp += corresponds;
118            if (temp > k) {
119                if (i == 2 * n - 1) {
120                    return n - 1;
121                } else {
122                    if (i % 2 == 0){
123                        if(i == 0) return 1000;
124                        return -y;
125                    }
126                    return x;
127                }
128            }
129            if (i % 2 == 1) x++;
130            else y++;
131        }
132        return x;
133    }
134
135    static int[] four(int n, long k) {
136        if (k > 8) return new int[] {};
137        if (k == 1) return new int[] { 1, 2, 3, 4 };
138        if (k == 2) return new int[] { 1, 4, 3, 2 };
139        if (k == 3) return new int[] { 2, 1, 4, 3 };
140        if (k == 4) return new int[] { 2, 3, 4, 1 };
141        if (k == 5) return new int[] { 3, 2, 1, 4 };
142        if (k == 6) return new int[] { 3, 4, 1, 2 };
143        if (k == 7) return new int[] { 4, 1, 2, 3 };
144        return new int[] { 4, 3, 2, 1 };
145    }
146
147    static int[] three(int n, long k) {
148        if (k > 2) return new int[] {};
149        if (k == 1) return new int[] { 1, 2, 3 };
150        return new int[] { 3, 2, 1 };
151    }
152
153    static int[] two(int n, long k) {
154        if (k > 2) return new int[] {};
155        if (k == 1) return new int[] { 1, 2 };
156        return new int[] { 2, 1 };
157    }
158
159    static int[] one(int n, long k) {
160        if (k > 1) return new int[] {};
161        return new int[] { 1 };
162    }
163
164    static int index(ArrayList<Integer> l, long corresponds, long requires) {
165        int n = l.size(), idx = 0;
166        long sum = corresponds;
167        requires %= n * corresponds;
168        if (requires == 0) return n - 1;
169        for (int i = 0; i < n; i++, sum += corresponds)
170            if (requires <= sum) return i;
171        return -1;
172    }
173}