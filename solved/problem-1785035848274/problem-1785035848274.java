// Last updated: 26/07/2026, 08:47:28
1class Solution {
2    static class Edge {
3        int src;
4        int dest;
5        long wt;
6        Edge(int src, int dest, long wt) {
7            this.src = src;
8            this.dest = dest;
9            this.wt = wt;
10        }
11    }
12
13    static class Pair {
14        int node;
15        long dist;
16        Pair(int node, long dist) {
17            this.node = node;
18            this.dist = dist;
19        }
20    }
21
22    static int V;
23    static ArrayList<Edge>[] g;
24    static int[] pt;
25    static long[] d;
26    static PriorityQueue<Pair> q;
27
28    public static long[] dij(int s, long w0) {
29        d = new long[g.length];
30        Arrays.fill(d, Long.MAX_VALUE);
31        d[s] = w0;
32        pt = new int[g.length];
33        Arrays.fill(pt, -1);
34        q = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));
35        q.offer(new Pair(s, w0));
36        
37        while (!q.isEmpty()) {
38            Pair c = q.poll();
39            int u = c.node;
40            long cd = c.dist;
41            
42            if (cd > d[u]) continue;
43            
44            for (Edge e : g[u]) {
45                int v = e.dest;
46                long w = e.wt;
47                if (d[u] + w < d[v]) {
48                    d[v] = d[u] + w;
49                    pt[v] = u;
50                    q.offer(new Pair(v, d[v]));
51                }
52            }
53        }
54        return d;
55    }
56    
57    public long minCost(int m, int n, int[][] p) {
58        V=m*n*2;
59        g=new ArrayList[V];
60        for(int i=0;i<V;i++)
61            g[i]=new ArrayList<>();
62
63        for(int r=0;r<m;r++){
64            for(int c=0;c<n;c++){
65                int px=p[r][c];
66                int u1=(r*n+c)*2+1;
67                int u0=(r*n+c)*2;
68
69                g[u1].add(new Edge(u1,u0,px));
70                g[u0].add(new Edge(u0,u1,px));
71                if(r+1<m){
72                    int v1=((r+1)*n+c)*2+1;
73                    int v0=((r+1)*n+c)*2;
74                    long w=(long)(r+2)*(c+1);
75                    g[u1].add(new Edge(u1,v0,w));
76                    g[u0].add(new Edge(u1,v1,w+px));
77                }
78                if(r+1<m){
79                    int v1=((r+1)*n+c)*2+1;
80                    int v0=((r+1)*n+c)*2;
81                    long w=(long)(r+2)*(c+1);
82                    g[u1].add(new Edge(u1,v0,w));
83                    g[u0].add(new Edge(u1,v1,w+px));
84                }
85                if(c+1<n){
86                    int v1=(r*n+(c+1))*2+1;
87                    int v0=(r*n+(c+1))*2;
88                    long w=(long)(r+1)*(c+2);
89                    g[u1].add(new Edge(u1,v0,w));
90                    g[u0].add(new Edge(u1,v1,w+px));
91                }
92                if(r-1>=0){
93                    int v1=((r-1)*n+c)*2+1;
94                    int v0=((r-1)*n+c)*2;
95                    long w=(long)(r)*(c+1);
96                    g[u0].add(new Edge(u0,v1,w));
97                    g[u1].add(new Edge(u1,v0,w+px));
98                }
99                if(c-1>=0){
100                    int v1=(r*n+(c-1))*2+1;
101                    int v0=(r*n+(c-1))*2;
102                    long w=(long)(r+1)*(c);
103                    g[u0].add(new Edge(u0,v1,w));
104                    g[u1].add(new Edge(u1,v0,w+px));
105                }
106            }
107        }
108        long[] res=dij(1,1);
109        int t0=(m*n-1)*2;
110        int t1=(m*n-1)*2+1;
111        long ans=Math.min(res[t0],res[t1]);
112        return ans==Long.MAX_VALUE?-1:ans;
113    }
114}