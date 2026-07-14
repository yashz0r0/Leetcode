// Last updated: 14/07/2026, 12:11:48
1class Solution {
2    int dp[];
3    public int climbStairs(int n) {
4      dp= new int[n+1];
5       Arrays.fill(dp,-1);
6
7       return solve(n);
8        
9    }
10    public int solve(int n){
11         if(n==0) return 0;
12        if(n==1) return 1;
13        if(n==2)return 2;
14
15        if(dp[n]!=-1)return dp[n];
16
17
18        return dp[n]=solve(n-1)+solve(n-2);
19    }
20}