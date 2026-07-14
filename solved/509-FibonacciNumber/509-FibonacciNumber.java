// Last updated: 14/07/2026, 12:10:08
1class Solution {
2    int dp[];
3    public int fib(int n) {
4       dp= new int[n+1];
5       Arrays.fill(dp,-1);
6
7       return solve(n);
8        
9    }
10    public int solve(int n){
11         if(n==0) return 0;
12        if(n==1) return 1;
13
14        if(dp[n]!=-1)return dp[n];
15
16
17        return dp[n]=solve(n-1)+solve(n-2);
18    }
19}