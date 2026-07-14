// Last updated: 14/07/2026, 12:24:10
1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int n=cost.length;
4
5        int dp[] = new int[n];
6        dp[0]=cost[0];
7        dp[1]=cost[1];
8
9
10        for(int i=2;i<n;i++){
11            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
12        }
13
14        return Math.min(dp[n-1],dp[n-2]);
15    }
16}