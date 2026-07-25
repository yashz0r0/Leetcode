// Last updated: 25/07/2026, 14:23:29
1class Solution {
2    Integer[][] dp;
3    public int uniquePaths(int m, int n) {
4        dp=new Integer[m+1][n+1];
5        return solve(0,0,m,n);
6
7    }
8    public int solve(int i, int j,int m,int n){
9        if(i>m||j>n)return 0;
10        if(i==m-1 && j==n-1)return 1;
11        if(dp[i][j]!=null)return dp[i][j];
12        int right=solve(i,j+1,m,n);
13        int down=solve(i+1,j,m,n);
14
15        return dp[i][j]=right+down;
16    }
17}