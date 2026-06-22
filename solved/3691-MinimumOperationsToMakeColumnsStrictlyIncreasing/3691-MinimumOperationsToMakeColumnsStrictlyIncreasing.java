// Last updated: 23/06/2026, 00:01:16
class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int operations = 0;

        for (int j = 0; j < n; j++) {
            int prev = grid[0][j];

            for (int i = 1; i < m; i++) {
                if (grid[i][j] <= prev) {
                    int needed = prev + 1;
                    operations += (needed - grid[i][j]);
                    prev = needed;
                } else {
                    prev = grid[i][j];
                }
            }
        }

        return operations;
    }
}