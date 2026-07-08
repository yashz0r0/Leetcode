// Last updated: 08/07/2026, 22:53:26
1class Solution {
2    public int[] sumAndMultiply(String s, int[][] queries) {
3        int n = s.length();
4        int mod = 1_000_000_007;
5
6        long[] prefSum = new long[n + 1];
7        long[] prefNum = new long[n + 1];
8        long[] pow10 = new long[n + 1];
9        int[] prefCnt = new int[n + 1]; 
10
11        pow10[0] = 1;
12
13        for (int i = 1; i <= n; i++) {
14            pow10[i] = (pow10[i - 1] * 10) % mod;
15        }
16
17        for (int i = 0; i < n; i++) {
18            char c = s.charAt(i);
19            int d = c - '0';
20
21            prefSum[i + 1] = prefSum[i] + (d == 0 ? 0 : d);
22            prefCnt[i + 1] = prefCnt[i] + (d == 0 ? 0 : 1);
23
24            if (d != 0) {
25                prefNum[i + 1] = (prefNum[i] * 10 + d) % mod;
26            } else {
27                prefNum[i + 1] = prefNum[i];
28            }
29        }
30
31        int q = queries.length;
32        int[] res = new int[q];
33
34        for (int i = 0; i < q; i++) {
35            int l = queries[i][0];
36            int r = queries[i][1];
37
38            long sum = prefSum[r + 1] - prefSum[l];
39            long x = prefNum[r + 1];
40            long left = prefNum[l];
41
42            int digits = prefCnt[r + 1] - prefCnt[l];
43
44            if (digits > 0) {
45                x = (x - (left * pow10[digits]) % mod + mod) % mod;
46            } else {
47                x = 0;
48            }
49
50            res[i] = (int) ((x * (sum % mod)) % mod);
51        }
52
53        return res;
54    }
55    }
56