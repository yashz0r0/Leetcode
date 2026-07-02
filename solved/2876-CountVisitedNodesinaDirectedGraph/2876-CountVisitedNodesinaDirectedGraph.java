// Last updated: 02/07/2026, 12:34:18
1class Solution {
2
3    public class Edge {
4        int src, dest;
5
6        public Edge(int s, int d) {
7            src = s;
8            dest = d;
9        }
10    }
11
12    int n;
13    ArrayList<Edge>[] graph;
14    boolean[] vis;
15    boolean[] pathvis;
16    int[] res;
17    Stack<Integer> st = new Stack<>();
18
19    public int[] countVisitedNodes(List<Integer> edges) {
20        n = edges.size();
21        graph = new ArrayList[n];
22        vis = new boolean[n];
23        pathvis = new boolean[n];
24        res = new int[n];
25
26        for (int i = 0; i < n; i++)
27            graph[i] = new ArrayList<>();
28
29        for (int i = 0; i < n; i++)
30            graph[i].add(new Edge(i, edges.get(i)));
31
32        for (int i = 0; i < n; i++) {
33            if (!vis[i])
34                dfs(i);
35        }
36
37        return res;
38    }
39
40   public void dfs(int vertex){
41    vis[vertex] = true;
42    pathvis[vertex] = true;
43    st.push(vertex);
44
45    for(Edge e : graph[vertex]){
46        int child = e.dest;
47
48        if(!vis[child]){
49            dfs(child);
50        }
51        else if(pathvis[child]){
52            List<Integer> cycle = new ArrayList<>();
53
54            while(st.peek() != child)
55                cycle.add(st.pop());
56
57            cycle.add(st.pop());
58
59            int len = cycle.size();
60
61            for(int x : cycle)
62                res[x] = len;
63        }
64        if(res[vertex] == 0)
65            res[vertex] = res[child] + 1;
66    }
67
68    pathvis[vertex] = false;
69
70    if(!st.isEmpty() && st.peek() == vertex)
71        st.pop();
72}
73}