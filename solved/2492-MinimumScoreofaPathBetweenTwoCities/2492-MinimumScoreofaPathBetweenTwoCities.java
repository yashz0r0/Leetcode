// Last updated: 04/07/2026, 18:24:04
1class Solution {
2
3    class Edge {
4        int src;
5        int dest;
6        int wt;
7
8        Edge(int s,int d, int w) {
9            this.src=s;
10            this.dest = d;
11            this.wt = w;
12        }
13    }
14
15    int ans = Integer.MAX_VALUE;
16
17    public int minScore(int n, int[][] roads) {
18
19        ArrayList<Edge>[] graph = new ArrayList[n + 1];
20
21        for (int i = 1; i <= n; i++)
22            graph[i] = new ArrayList<>();
23
24        for (int[] road : roads) {
25            int u = road[0];
26            int v = road[1];
27            int w = road[2];
28
29            graph[u].add(new Edge(u,v, w));
30            graph[v].add(new Edge(v,u, w));
31        }
32
33        boolean[] vis = new boolean[n + 1];
34        dfs(1, graph, vis);
35
36        return ans;
37    }
38
39    private void dfs(int vertex, ArrayList<Edge>[] graph, boolean[] vis) {
40
41        vis[vertex] = true;
42
43        for (Edge e : graph[vertex]) {
44            ans = Math.min(ans, e.wt);
45
46            if (!vis[e.dest]) {
47                dfs(e.dest, graph, vis);
48            }
49        }
50    }
51}