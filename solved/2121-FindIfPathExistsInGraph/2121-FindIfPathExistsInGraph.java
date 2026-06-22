// Last updated: 23/06/2026, 00:02:23
import java.util.*;

class Solution {

    class Edge {
        int src, dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public boolean validPath(int n, int[][] edges, int src, int dest) {

        ArrayList<Edge>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        // build graph
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            g[u].add(new Edge(u, v));
            g[v].add(new Edge(v, u)); // undirected
        }

     //   Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

       return hasPath(g, src, dest, visited);
    }

    public boolean hasPath(ArrayList<Edge>[] g, int curr, int dest, boolean[] visited){
        if(curr==dest) return true;
        visited[curr]=true;

        for(Edge e:g[curr]){
            if(!visited[e.dest]){
                if(hasPath(g, e.dest,dest,visited))return true;
            }
        }

        return false;
    }
}