// Last updated: 02/07/2026, 17:29:48
1class Solution {
2    int n, m;
3    int newColor;
4    int original;
5
6    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
7        n = grid.length;
8        m = grid[0].length;
9
10        newColor = color;
11        original = grid[sr][sc];
12        if(original == newColor) return grid;
13
14        dfs(grid, sr, sc);
15
16        return grid;
17    }
18
19    public void dfs(int[][] grid, int i, int j){
20        if(i < 0 || j < 0 || i >= n || j >= m) return;
21
22        if(grid[i][j] != original) return;
23
24        grid[i][j] = newColor;
25        dfs(grid, i+1, j);
26        dfs(grid, i-1, j);
27        dfs(grid, i, j+1);
28        dfs(grid, i, j-1);
29    }
30}