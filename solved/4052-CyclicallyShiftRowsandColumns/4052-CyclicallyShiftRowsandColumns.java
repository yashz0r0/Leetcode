// Last updated: 13/09/2026, 16:17:43
1class Solution {
2    public int[][] cyclicShift(int n, int[][] grid, int[] row, int[] col) {
3        int ret[][]=new int[n][n];
4    for(int i=0;i<n;i++){
5    for(int j=0;j<n;j++){
6    int c=(j+(row[i]%n))%n;
7    int r=(n+i-(col[j]%n))%n;
8    ret[r][j]=grid[i][c];
9    }
10    }
11    return ret;
12    }
13}