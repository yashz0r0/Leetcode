// Last updated: 22/07/2026, 14:44:27
1class Solution {
2
3    class Edge {
4        int s, d, wt;
5
6        Edge(int s, int d, int wt) {
7            this.s = s;
8            this.d = d;
9            this.wt = wt;
10        }
11    }
12
13    class Pair {
14        int node;
15        long dist;
16
17        Pair(int node, long dist) {
18            this.node = node;
19            this.dist = dist;
20        }
21    }
22
23    static final int MOD = 1_000_000_007;
24
25    public int dijkstra(ArrayList<Edge>[] graph, int src) {
26
27        int n = graph.length;
28
29        long[] dist = new long[n];
30        int[] ways = new int[n];
31
32        Arrays.fill(dist, Long.MAX_VALUE);
33
34        dist[src] = 0;
35        ways[src] = 1;
36
37        PriorityQueue<Pair> pq =
38                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
39
40        pq.offer(new Pair(src, 0));
41
42        while (!pq.isEmpty()) {
43
44            Pair cur = pq.poll();
45
46            int u = cur.node;
47
48            if (cur.dist > dist[u])
49                continue;
50
51            for (Edge e : graph[u]) {
52
53                int v = e.d;
54                int wt = e.wt;
55
56                if (dist[u] + wt < dist[v]) {
57
58                    dist[v] = dist[u] + wt;
59                    ways[v] = ways[u];
60                    pq.offer(new Pair(v, dist[v]));
61
62                } else if (dist[u] + wt == dist[v]) {
63
64                    ways[v] = (ways[v] + ways[u]) % MOD;
65                }
66            }
67        }
68
69        return ways[n - 1];
70    }
71
72    public int countPaths(int n, int[][] roads) {
73
74        ArrayList<Edge>[] graph = new ArrayList[n];
75
76        for (int i = 0; i < n; i++)
77            graph[i] = new ArrayList<>();
78
79        for (int[] r : roads) {
80
81            int u = r[0];
82            int v = r[1];
83            int wt = r[2];
84
85            graph[u].add(new Edge(u, v, wt));
86            graph[v].add(new Edge(v, u, wt));
87        }
88
89        return dijkstra(graph, 0);
90    }
91}