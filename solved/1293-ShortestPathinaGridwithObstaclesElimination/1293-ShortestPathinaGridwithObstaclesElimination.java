// Last updated: 10/07/2026, 22:54:06
1class Solution {
2     int m, n;
3    public boolean invalid(int x, int y){
4        return x < 0 || x >= m || y < 0 || y >= n;
5    }
6    public int shortestPath(int[][] grid, int k) {
7        m=grid.length;
8        n=grid[0].length;
9        boolean vis[][][]=new boolean[m][n][k+1];
10        int lev[][][] = new int[m][n][k+1];
11        
12        for (int i = 0; i < m; i++)
13            for (int j = 0; j < n; j++)
14                Arrays.fill(lev[i][j], Integer.MAX_VALUE);
15
16        int[][] dir= {
17            {0, 1},
18            {0, -1},
19            {1, 0},
20            {-1, 0}
21        };
22
23        Queue<int[]> q=new LinkedList<>();
24        q.offer(new int[]{0,0,k});
25        lev[0][0][k] = 0;
26        vis[0][0][k] = true;
27
28        while(!q.isEmpty()){
29            int[] v=q.poll();
30            int vx=v[0];
31            int vy=v[1];
32            int vo=v[2];//obstical limit
33
34            if(vx==(m-1)&&vy==(n-1))return lev[vx][vy][vo];
35    
36            for(int[] d:dir){
37                int cx=vx+d[0];
38                int cy=vy+d[1];
39                int co=vo;
40
41
42                if(invalid(cx,cy))continue;
43
44                if(grid[cx][cy]==1){
45                    if(co==0)continue;
46                    co--;
47                }
48                if(vis[cx][cy][co])continue;
49                vis[cx][cy][co]=true;
50                lev[cx][cy][co]=lev[vx][vy][vo]+1;
51                q.offer(new int[]{cx,cy,co});
52            
53            }
54        }
55
56        return -1;
57    }
58}