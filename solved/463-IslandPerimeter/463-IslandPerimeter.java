// Last updated: 22/06/2026, 23:53:06
class Solution {
    int n;
    int m;
    public int islandPerimeter(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return dfs(grid,i,j);
                }
            }
        }

        return 0;
        
    }

    public int dfs(int[][] grid, int i, int j){
              if(i < 0 || j < 0 || i >= n || j >= m||grid[i][j]==0) return 1;
          


        if(grid[i][j]==-1)return 0;

        grid[i][j]=-1;

        return dfs(grid,i+1,j)+dfs(grid,i,j+1)+dfs(grid,i-1,j)+dfs(grid,i,j-1);
    }
}