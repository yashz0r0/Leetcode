// Last updated: 25/07/2026, 14:47:48
1class Solution {
2    Integer[][] dp;
3    int[][] grid;
4
5    public int minPathSum(int[][] grid) {
6        this.grid=grid;
7        int m=grid.length;
8        int n=grid[0].length;
9        dp=new Integer[m][n];
10        return solve(0,0,m,n);
11    }
12
13    public int solve(int i, int j,int m,int n){
14        if(i==m-1 && j==n-1)return grid[i][j];
15        if(dp[i][j]!=null)return dp[i][j];
16        int right = (j + 1 < n) ? solve(i, j + 1, m, n) : Integer.MAX_VALUE;
17        int down  = (i + 1 < m) ? solve(i + 1, j, m, n) : Integer.MAX_VALUE;
18
19        return dp[i][j]=Math.min(right,down)+grid[i][j];
20    }
21}
22