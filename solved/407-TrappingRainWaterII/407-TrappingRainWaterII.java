// Last updated: 09/07/2026, 23:32:12
1class Solution {
2
3    class Cell {
4        int x, y, h;
5
6        Cell(int x, int y, int h) {
7            this.x = x;
8            this.y = y;
9            this.h = h;
10        }
11    }
12
13    public int trapRainWater(int[][] heightMap) {
14        int n = heightMap.length;
15        int m = heightMap[0].length;
16
17        if (n <= 2 || m <= 2) return 0;
18
19        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.h - b.h);
20        boolean[][] vis = new boolean[n][m];
21
22        for (int i = 0; i < n; i++) {
23            pq.offer(new Cell(i, 0, heightMap[i][0]));
24            pq.offer(new Cell(i, m - 1, heightMap[i][m - 1]));
25            vis[i][0] = true;
26            vis[i][m - 1] = true;
27        }
28
29        for (int j = 1; j < m - 1; j++) {
30            pq.offer(new Cell(0, j, heightMap[0][j]));
31            pq.offer(new Cell(n - 1, j, heightMap[n - 1][j]));
32            vis[0][j] = true;
33            vis[n - 1][j] = true;
34        }
35
36        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
37        int ans = 0;
38
39        while (!pq.isEmpty()) {
40            Cell cur = pq.poll();
41
42            for (int[] d : dir) {
43                int nx = cur.x + d[0];
44                int ny = cur.y + d[1];
45
46                if (nx < 0 || ny < 0 || nx >= n || ny >= m || vis[nx][ny]) {
47                    continue;
48                }
49
50                vis[nx][ny] = true;
51
52                if (heightMap[nx][ny] < cur.h) {
53                    ans += cur.h - heightMap[nx][ny];
54                }
55
56                pq.offer(new Cell(nx, ny, Math.max(cur.h, heightMap[nx][ny])));
57            }
58        }
59
60        return ans;
61    }
62}