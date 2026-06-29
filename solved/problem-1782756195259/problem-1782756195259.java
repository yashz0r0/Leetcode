// Last updated: 29/06/2026, 23:33:15
1class Solution {
2    int n, m;
3
4    public int maxAreaOfIsland(int[][] grid) {
5        n = grid.length;
6        m = grid[0].length;
7
8        int maxArea = 0;
9
10        for(int i = 0; i < n; i++){
11            for(int j = 0; j < m; j++){
12                if(grid[i][j] == 1){
13                    maxArea = Math.max(maxArea, dfs(grid, i, j));
14                }
15            }
16        }
17
18        return maxArea;
19    }
20
21    public int dfs(int[][] grid, int i,int j){
22        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0){
23            return 0;
24        }
25
26        int area=1;
27        grid[i][j]=0;
28
29         area+=dfs(grid,i-1,j);
30         area+=dfs(grid,i+1,j);
31         area+=dfs(grid,i,j-1);
32         area+=dfs(grid,i,j+1);
33
34
35
36        return area;
37    }
38
39}