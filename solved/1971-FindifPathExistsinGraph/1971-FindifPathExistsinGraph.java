// Last updated: 29/06/2026, 19:07:58
1import java.util.*;
2
3class Solution {
4
5    class Edge {
6        int src, dest;
7
8        public Edge(int s, int d) {
9            this.src = s;
10            this.dest = d;
11        }
12    }
13
14    public boolean validPath(int n, int[][] edges, int src, int dest) {
15
16        ArrayList<Edge>[] g = new ArrayList[n];
17
18        for (int i = 0; i < n; i++) {
19            g[i] = new ArrayList<>();
20        }
21
22        // build graph
23        for (int[] e : edges) {
24            int u = e[0];
25            int v = e[1];
26            g[u].add(new Edge(u, v));
27            g[v].add(new Edge(v, u)); 
28        }
29
30        boolean[] visited = new boolean[n];
31
32       return hasPath(g, src, dest, visited);
33    }
34
35    public boolean hasPath(ArrayList<Edge>[] g, int curr, int dest, boolean[] visited){
36        if(curr==dest) return true;
37        visited[curr]=true;
38
39        for(Edge e:g[curr]){
40            if(!visited[e.dest]){
41                if(hasPath(g,e.dest,dest,visited))return true;
42            }
43        }
44
45        return false;
46    }
47}