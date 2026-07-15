// Last updated: 15/07/2026, 14:09:57
1class Solution {
2    int[] nums;
3    int[] dp;
4    public int rob(int[] nums) {
5        int n=nums.length;
6        if(n==1)return nums[0];
7        this.nums=nums;
8        dp = new int[n];
9        Arrays.fill(dp, -1);
10        int ans1 = rec(n - 2, 0);
11
12        dp = new int[n];
13        Arrays.fill(dp, -1);
14        int ans2 = rec(n - 1, 1);
15
16        return Math.max(ans1, ans2);
17    }
18
19    int rec(int i, int start) {
20        if (i < start)
21            return 0;
22
23        if (dp[i] != -1)
24            return dp[i];
25
26        int rob = nums[i] + rec(i - 2, start);
27        int skip = rec(i - 1, start);
28
29        return dp[i] = Math.max(rob, skip);
30    }
31}