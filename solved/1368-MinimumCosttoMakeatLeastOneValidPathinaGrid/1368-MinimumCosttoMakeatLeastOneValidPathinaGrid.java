// Last updated: 08/07/2026, 00:06:37
1class Solution {
2    int m, n;
3    public boolean isvalid(int x, int y){
4        return x < 0 || x >= m || y < 0 || y >= n;
5    }
6    public int minCost(int[][] grid) {
7
8          m = grid.length;
9          n = grid[0].length;
10
11        int[][] lev = new int[m][n];
12        for (int[] row : lev)
13            Arrays.fill(row, Integer.MAX_VALUE);
14    
15        int[][] dir = {
16            {0, 1,1},
17            {0, -1,2},
18            {1, 0,3},
19            {-1, 0,4}
20        };
21
22        Deque<int[]> dq = new ArrayDeque<>();
23
24        lev[0][0] = 0;
25        dq.offerFirst(new int[]{0, 0});
26
27        while (!dq.isEmpty()) {
28
29            int[] ver = dq.pollFirst();
30            int vx = ver[0];
31            int vy = ver[1];
32
33            for (int[]d:dir) {
34
35                int childX = vx + d[0];
36                int childy = vy + d[1];
37
38                if (isvalid(childX, childy)) continue;
39
40                int wt = (grid[vx][vy] == d[2] ) ? 0 : 1;
41
42                if (lev[vx][vy] + wt < lev[childX][childy]) {
43                    
44                    lev[childX][childy]= lev[vx][vy] + wt;
45                    if (wt == 0)
46                        dq.offerFirst(new int[]{childX, childy});
47                    else
48                        dq.offerLast(new int[]{childX, childy});
49                }
50            }
51        }
52
53        return lev[m - 1][n - 1];
54    }
55}