// Last updated: 29/06/2026, 21:43:00
1class Solution {
2
3    class Edge{
4        int src;
5        int dest;
6
7        public Edge(int s,int d){
8            this.src=s;
9            this.dest=d;
10        }
11    }
12
13    int nodes;
14    int edge=0;
15    public int countCompleteComponents(int n, int[][] edges) {
16        ArrayList<Edge>[] g= new ArrayList[n];
17
18
19        for(int i=0;i<n;i++){
20            g[i]=new ArrayList<>();
21        }
22
23        for(int[] e:edges){
24            int u=e[0];
25            int v=e[1];
26            g[u].add(new Edge(u,v));
27            g[v].add(new Edge(v,u));
28        }
29        int cnt=0;
30        boolean[] vis= new boolean[n];
31        
32        for(int i=0;i<n;i++){
33            if(!vis[i]){
34                nodes=0;
35                edge=0;
36                dfs(g,i,vis);
37
38                if(edge/2==(nodes*(nodes-1)/2))cnt++;
39            }
40        }
41
42
43        return cnt;
44    }
45
46    public void dfs(ArrayList<Edge>[] g,int curr ,boolean[] vis){
47
48        vis[curr]=true;
49        nodes++;
50        edge+=g[curr].size();
51        for(Edge e: g[curr]){
52            if(!vis[e.dest])dfs(g,e.dest,vis);
53        }
54    }
55}