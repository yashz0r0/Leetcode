// Last updated: 17/07/2026, 22:50:30
1
2class Solution {
3
4    public int[] gcdValues(int[] nums, long[] queries) {
5
6        int max = 0;
7        for (int x : nums) {
8            if (x > max) max = x;
9        }
10
11        int[] freq = new int[max + 1];
12
13        for (int x : nums) {
14            freq[x]++;
15        }
16
17        int[] divisible = new int[max + 1];
18
19        for (int d = 1; d <= max; d++) {
20            for (int m = d; m <= max; m += d) {
21                divisible[d] += freq[m];
22            }
23        }
24
25        long[] exact = new long[max + 1];
26
27        for (int d = max; d >= 1; d--) {
28
29            long cnt = divisible[d];
30            exact[d] = cnt * (cnt - 1L) / 2L;
31
32            for (int m = d + d; m <= max; m += d) {
33                exact[d] -= exact[m];
34            }
35        }
36
37        long[] prefix = new long[max + 1];
38
39        for (int i = 1; i <= max; i++) {
40            prefix[i] = prefix[i - 1] + exact[i];
41        }
42
43        int[] ans = new int[queries.length];
44
45        for (int i = 0; i < queries.length; i++) {
46
47            long k = queries[i];
48
49            int l = 1;
50            int r = max;
51
52            while (l < r) {
53                int mid = (l + r) >>> 1;
54
55                if (prefix[mid] > k) {
56                    r = mid;
57                } else {
58                    l = mid + 1;
59                }
60            }
61
62            ans[i] = l;
63        }
64
65        return ans;
66    }
67}