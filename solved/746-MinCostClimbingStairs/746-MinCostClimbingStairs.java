// Last updated: 14/07/2026, 12:23:34
1class Solution {
2    int cost[];
3    int[] dp;
4    public int minCostClimbingStairs(int[] cost) {
5        this.cost=cost;
6        int n=cost.length;
7        dp= new int[n+1];
8       Arrays.fill(dp,-1);
9
10       return solve(n);
11        
12    }
13    public int solve(int n){
14         if(n==0) return cost[0];
15        if(n==1) return cost[1];
16
17        if(dp[n]!=-1)return dp[n];
18        if(n==cost.length)  return dp[n] = Math.min(solve(n - 1), solve(n - 2));
19        
20        return dp[n]=cost[n]+Math.min(solve(n-1),solve(n-2));
21    }
22
23}