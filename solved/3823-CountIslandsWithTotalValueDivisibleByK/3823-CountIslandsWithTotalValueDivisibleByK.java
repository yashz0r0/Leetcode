// Last updated: 23/06/2026, 00:01:10
class Solution {
    int n, m;

    public int countIslands(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] > 0){
                    long sum = dfs(grid, i, j);

                    if(sum % k == 0){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public long dfs(int[][] grid, int i, int j){
   
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0){
            return 0;
        }

        int val = grid[i][j];

     
        grid[i][j] = 0;

        long sum = val;

        sum += dfs(grid, i+1, j);
        sum += dfs(grid, i-1, j);
        sum += dfs(grid, i, j+1);
        sum += dfs(grid, i, j-1);

        return sum;
    }
}