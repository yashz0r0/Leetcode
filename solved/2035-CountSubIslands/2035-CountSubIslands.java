// Last updated: 23/06/2026, 00:02:32
class Solution {
    int m, n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1 && grid1[i][j] == 0){
                    dfs(grid2, i, j);
                }
            }
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1){
                    dfs(grid2, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0)
            return;

        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}