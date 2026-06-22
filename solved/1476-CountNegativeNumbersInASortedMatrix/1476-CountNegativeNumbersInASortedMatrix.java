// Last updated: 23/06/2026, 00:03:21
class Solution {
    public int countNegatives(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]<0)cnt++;
            }
        }


        return cnt;
    }
}