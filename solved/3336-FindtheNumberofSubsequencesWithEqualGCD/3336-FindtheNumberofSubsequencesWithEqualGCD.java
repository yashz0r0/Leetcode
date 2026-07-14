// Last updated: 15/07/2026, 00:34:14
1class Solution {
2    private static final int MOD = 1_000_000_007;
3    private int n;
4    private int[][][] dp;
5
6    private int solve(int idx, int g1, int g2, int[] nums) {
7        if (idx == n) {
8            return (g1 != 0 && g1 == g2) ? 1 : 0;
9        }
10
11        if (dp[idx][g1][g2] != -1)
12            return dp[idx][g1][g2];
13
14        long ans = 0;
15
16        ans = solve(idx + 1, g1, g2, nums);
17
18        int ng1 = (g1 == 0) ? nums[idx] : gcd(g1, nums[idx]);
19        ans = (ans + solve(idx + 1, ng1, g2, nums)) % MOD;
20
21        int ng2 = (g2 == 0) ? nums[idx] : gcd(g2, nums[idx]);
22        ans = (ans + solve(idx + 1, g1, ng2, nums)) % MOD;
23
24        return dp[idx][g1][g2] = (int) ans;
25    }
26
27    public int subsequencePairCount(int[] nums) {
28        n = nums.length;
29        dp = new int[n + 1][201][201];
30
31        for (int i = 0; i <= n; i++) {
32            for (int j = 0; j <= 200; j++) {
33                Arrays.fill(dp[i][j], -1);
34            }
35        }
36
37        return solve(0, 0, 0, nums);
38    }
39
40    private int gcd(int a, int b) {
41        while (b != 0) {
42            int t = a % b;
43            a = b;
44            b = t;
45        }
46        return a;
47    }
48}