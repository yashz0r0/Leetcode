// Last updated: 21/07/2026, 15:32:55
1class Solution {
2    int n;
3    int m;
4
5    public int findCircleNum(int[][] isConnected) {
6        n = isConnected.length;
7        m = isConnected[0].length;
8
9        int cnt = 0;
10        for (int i = 0; i < n; i++) {
11            if (isConnected[i][i] == 1) {
12                dfs(isConnected, i, i);
13                cnt++;
14            }
15        }
16
17        return cnt;
18    }
19
20    public void dfs(int[][] grid, int i, int j) {
21        if (grid[i][i] == 0) return;
22
23        grid[i][i] = 0;
24
25        for (int k = 0; k < n; k++) {
26            if (grid[i][k] == 1) {
27                dfs(grid, k, k);
28            }
29        }
30    }
31}