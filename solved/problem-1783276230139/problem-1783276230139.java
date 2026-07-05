// Last updated: 06/07/2026, 00:00:30
1class Solution {
2    public int projectionArea(int[][] grid) {
3        int n=grid.length;
4
5        int ans=0;
6
7        for(int i=0;i<n;i++){
8            int max1=0;
9            int max2=0;
10            for(int j=0;j<n;j++){
11
12                if(grid[i][j]!=0)ans++;
13                max1=Math.max(max1,grid[i][j]);
14                max2=Math.max(max2,grid[j][i]);
15            }
16
17            ans+=max1;
18            ans+=max2;
19        }
20
21        return ans;
22
23        
24        
25    }
26}